package com.mungge.orumi.domain.diary.application;

import com.mungge.orumi.domain.diary.dao.DiaryRepository;
import com.mungge.orumi.domain.diary.domain.Diary;
import com.mungge.orumi.domain.diary.domain.Emotion;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class DiaryService {

    private final DiaryRepository diaryRepository;

    public String createDiary(Diary diary) {
        diaryRepository.save(diary);
        return "save";
    }

    public String updateDiary(Diary diary) {
        diaryRepository.save(diary);
        return "update";
    }

    public Diary getDiary(String userId, LocalDate date) {
        Diary diary = diaryRepository.findByUserIdAndDate(userId, date);
        return diary;
    }
}

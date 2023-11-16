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

    @Transactional
    public void saveDiary(Diary diary){
        diaryRepository.save(diary);
    }

    public Diary findOne(Long diaryId) {
        return diaryRepository.findOne(diaryId);
    }

    @Transactional
    public void updateDiary(Long diaryId, String userId, Emotion emotion, String text, String image, LocalDate date)
    {
        Diary diary = diaryRepository.findOne(diaryId);
        diary.setUserId(userId);
        diary.setEmotion(emotion);
        diary.setText(text);
        diary.setImage(image);
        diary.setDate(date);
    }
}

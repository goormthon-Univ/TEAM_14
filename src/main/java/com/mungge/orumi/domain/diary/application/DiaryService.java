package com.mungge.orumi.domain.diary.application;

import com.mungge.orumi.domain.diary.dao.DiaryRepository;
import com.mungge.orumi.domain.diary.domain.Diary;

import com.mungge.orumi.domain.diary.domain.Emotion;
import com.mungge.orumi.domain.emotion.application.EmotionCountService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class DiaryService {

    private final DiaryRepository diaryRepository;
    private final EmotionCountService emotionCountService;

    public void createDiary(Diary diary) {
//        emotionCountService.plusEmotion(diary.getEmotion());
        diaryRepository.save(diary);
    }

    public Long updateDiary(Diary diary) {
//        Emotion pastDiaryEmotion = diaryRepository.getReferenceById(diary.getDiaryId()).getEmotion();
//        if(pastDiaryEmotion != diary.getEmotion()) {
//            emotionCountService.plusEmotion(diary.getEmotion());
//            emotionCountService.minusEmotion(pastDiaryEmotion);
//        }
        Diary temp = diaryRepository.save(diary);
        return temp.getDiaryId();
    }

    public Diary getDiary(String userId, LocalDate date) {
        Diary diary = diaryRepository.findByUserIdAndDate(userId, date);
        return diary;
    }
}

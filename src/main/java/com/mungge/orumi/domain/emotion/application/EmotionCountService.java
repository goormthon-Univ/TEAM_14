package com.mungge.orumi.domain.emotion.application;

import com.mungge.orumi.domain.emotion.dao.EmotionCountRepository;
import com.mungge.orumi.domain.diary.domain.Diary;
import com.mungge.orumi.domain.diary.domain.Emotion;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EmotionCountService {

    private final EmotionCountRepository diaryEmotionRepository;

    // 평화, 신남, 행복, 지침, 화남, 슬픔 순으로 반환
    public List<Integer> getAllCountByEmotion(String userId) {
        List<Integer> list = new ArrayList<>();
        LocalDate start = YearMonth.now().atDay(1);
        LocalDate today = LocalDate.now();

        for(int i = 0; i < 6; i++) {
            int cnt = diaryEmotionRepository.countAllByUserIdAndEmotionAndDateBetween(userId, i, start, today);
            list.add(cnt);
        }
        return list;
    }

    // 이번달 1일부터 말일까지의 감정을 반환
    // 가입일부터 오늘까지로 변경??
    public List<Emotion> getEmotionsOfMonth(String userId) {
        List<Diary> tempList = new ArrayList<>();
        List<Emotion> list = new ArrayList<>();
        LocalDate start = YearMonth.now().atDay(1);
        LocalDate today = LocalDate.now();
        tempList = diaryEmotionRepository.findByUserIdAndDateBetween(userId, start, today);

        LocalDate now = start;
        for (Diary diary : tempList) {
            if (diary.getDate() != now) {
                // 오늘 기록이 없는 경우
                list.add(null);
            }
            else {
                list.add(diary.getEmotion());
            }
            now = now.plusDays(1);
        }

        while (now.isBefore(today.withDayOfMonth(today.lengthOfMonth()))) {
            list.add(null);
            now = now.plusDays(1);
        }
        return list;
    }
}

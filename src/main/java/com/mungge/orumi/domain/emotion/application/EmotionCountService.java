package com.mungge.orumi.domain.emotion.application;

import com.mungge.orumi.domain.diary.domain.Diary;
import com.mungge.orumi.domain.diary.domain.Emotion;
import com.mungge.orumi.domain.emotion.dao.RecordRepository;
import com.mungge.orumi.domain.emotion.domain.EmotionCount;
import com.mungge.orumi.domain.user.dao.UserRepository;
import com.mungge.orumi.domain.user.domain.User;
import com.mungge.orumi.global.common.Pair;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EmotionCountService {

    private final UserRepository userRepository;
    private final RecordRepository recordRepository;

    // 감정 횟수 메소드
    private int getCountOfEmotionInterface(String userId, Emotion emotion) {
        LocalDate start = YearMonth.now().atDay(1);
        LocalDate today = LocalDate.now();
        int count = recordRepository.countDiaryByUserIdAndEmotionAndDateBetween(userId, emotion, start, today);
        return count;
    }

    // 평화 횟수
    private int getCountOfPeace(String userId) {
        return getCountOfEmotionInterface(userId, Emotion.PEACEFUL);
    }

    // 신남 횟수
    private int getCountOfExcited(String userId) {
        return getCountOfEmotionInterface(userId, Emotion.EXCITED);
    }

    // 행복 횟수
    private int getCountOfHappy(String userId) {
        return getCountOfEmotionInterface(userId, Emotion.HAPPY);
    }

    // 지침 횟수
    private int getCountOfTired(String userId) {
        return getCountOfEmotionInterface(userId, Emotion.TIRED);
    }

    // 화남 횟수
    private int getCountOfAngry(String userId) {
        return getCountOfEmotionInterface(userId, Emotion.ANGRY);
    }

    // 슬픔 횟수
    private int getCountOfSad(String userId) {
        return getCountOfEmotionInterface(userId, Emotion.SAD);
    }

    public int getCountOfEmotion(String userId, String emotion) {
        if (emotion == "peace") {
            return getCountOfPeace(userId);
        } else if (emotion == "happy") {
            return getCountOfHappy(userId);
        } else if (emotion == "excited") {
            return getCountOfExcited(userId);
        } else if (emotion == "tired") {
            return getCountOfTired(userId);
        } else if (emotion == "angry") {
            return getCountOfAngry(userId);
        } else {
            return getCountOfSad(userId);
        }

    }

    // 평화, 신남, 행복, 지침, 화남, 슬픔 순으로 반환
    public List<Integer> getAllCountByEmotion(String userId) {
        List<Integer> list = new ArrayList<>();
        LocalDate start = YearMonth.now().atDay(1);
        LocalDate today = LocalDate.now();

//        for(int i = 0; i < 6; i++) {
//            int cnt = recordRepository
//                    .countAllByUserIdAndEmotionAndDateBetween(userId, i, start, today);
//            list.add(cnt);
//        }
        list.add(getCountOfPeace(userId));
        list.add(getCountOfExcited(userId));
        list.add(getCountOfHappy(userId));
        list.add(getCountOfTired(userId));
        list.add(getCountOfAngry(userId));
        list.add(getCountOfSad(userId));

        return list;
    }

    // 가입일부터 오늘까지의 날씨 반환
    public List<Pair<LocalDate, Emotion>> getEmotionsOfMonth(String userId) throws Exception {
        User user = (User) userRepository.findById(userId);
        List<Pair<LocalDate, Emotion>> list = new ArrayList<>();
        LocalDate start = user.getJoinDate();
        LocalDate today = LocalDate.now();

        LocalDate now = start;


        while (!now.isAfter(today)) {
            Diary diary = recordRepository.findByUserIdAndDate(userId, now);
            if (diary == null) {
                list.add(new Pair<>(now, null));
            } else list.add(new Pair<>(now, diary.getEmotion()));
            now = now.plusDays(1);
        }

        return list;
    }

    public void plusEmotion(Emotion emotion){
        EmotionCount emotionCount = null;
        if(emotion.PEACEFUL.getValue() == 0) emotionCount.setPeaceCnt(emotionCount.getPeaceCnt() + 1);
        if(emotion.EXCITED.getValue() == 1) emotionCount.setExcitedCnt(emotionCount.getExcitedCnt() + 1);
        if(emotion.HAPPY.getValue() == 2) emotionCount.setHappyCnt(emotionCount.getHappyCnt() + 1);
        if(emotion.TIRED.getValue() == 3) emotionCount.setTiredCnt(emotionCount.getTiredCnt() + 1);
        if(emotion.ANGRY.getValue() == 4) emotionCount.setAngryCnt(emotionCount.getAngryCnt() + 1);
        if(emotion.SAD.getValue() == 5) emotionCount.setSadCnt(emotionCount.getSadCnt() + 1);
    }

    public void minusEmotion(Emotion emotion) {
        EmotionCount emotionCount = null;
        if(emotion.PEACEFUL.getValue() == 0) emotionCount.setPeaceCnt(emotionCount.getPeaceCnt() - 1);
        if(emotion.EXCITED.getValue() == 1) emotionCount.setExcitedCnt(emotionCount.getExcitedCnt() - 1);
        if(emotion.HAPPY.getValue() == 2) emotionCount.setHappyCnt(emotionCount.getHappyCnt() - 1);
        if(emotion.TIRED.getValue() == 3) emotionCount.setTiredCnt(emotionCount.getTiredCnt() - 1);
        if(emotion.ANGRY.getValue() == 4) emotionCount.setAngryCnt(emotionCount.getAngryCnt() - 1);
        if(emotion.SAD.getValue() == 5) emotionCount.setSadCnt(emotionCount.getSadCnt() - 1);
    }

//    public void saveEmotion() {
//        recordRepository.save()
//    }
}

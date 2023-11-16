package com.mungge.orumi.domain.user.application;

import com.mungge.orumi.domain.emotion.dao.EmotionCountRepository;
import com.mungge.orumi.domain.emotion.domain.EmotionCount;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MyPageService {

    private final EmotionCountRepository emotionCountRepository;

    public int getTotalCount(String userId) {
        EmotionCount userCount = emotionCountRepository.findByUserId(userId);
        int total = userCount.getPeaceCnt() + userCount.getExcitedCnt() + userCount.getHappyCnt() + userCount.getTiredCnt() + userCount.getAngryCnt() + userCount.getSadCnt();
        return total;
    }
}

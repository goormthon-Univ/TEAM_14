package com.mungge.orumi.domain.emotion.dao;

import com.mungge.orumi.domain.emotion.domain.EmotionCount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmotionCountRepository extends JpaRepository<EmotionCount, Long> {

    public EmotionCount findByUserId(String userId);
}

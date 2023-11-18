package com.mungge.orumi.domain.emotion.dto;

import com.mungge.orumi.domain.diary.domain.Emotion;
import com.mungge.orumi.global.common.Pair;
import lombok.Getter;

import java.time.LocalDate;
import java.util.List;

@Getter
public class WeatherDto {
    private String userId;
    private List<Pair<LocalDate, Emotion>> dateEmotion;

    public WeatherDto(String userId, List<Pair<LocalDate, Emotion>> dateEmotion) {
        this.userId = userId;
        this.dateEmotion = dateEmotion;
    }
}

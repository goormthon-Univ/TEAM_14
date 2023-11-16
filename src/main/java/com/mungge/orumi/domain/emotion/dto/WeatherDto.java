package com.mungge.orumi.domain.emotion.dto;

import com.mungge.orumi.domain.diary.domain.Emotion;
import lombok.Getter;

import java.util.List;

@Getter
public class WeatherDto {
    private String userId;
    private List<Emotion> weatherList;

    public WeatherDto(String userId, List<Emotion> weatherList) {
        this.userId = userId;
        this.weatherList = weatherList;
    }
}

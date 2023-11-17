package com.mungge.orumi.domain.emotion.dto;

import com.mungge.orumi.domain.diary.domain.Emotion;
import lombok.Getter;

import java.time.LocalDate;
import java.util.List;

@Getter
public class WeatherDto {
    private String userId;
    private LocalDate joinDate;
    private List<Emotion> weatherList;

    public WeatherDto(String userId, LocalDate joinDate, List<Emotion> weatherList) {
        this.userId = userId;
        this.joinDate = joinDate;
        this.weatherList = weatherList;
    }
}

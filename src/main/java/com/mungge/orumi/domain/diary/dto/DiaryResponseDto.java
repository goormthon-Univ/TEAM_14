package com.mungge.orumi.domain.diary.dto;

import com.mungge.orumi.domain.Image.domain.Image;
import com.mungge.orumi.domain.diary.domain.Emotion;
import lombok.Getter;

import java.time.LocalDate;

@Getter
public class DiaryResponseDto {
    Emotion emotion;
    String text;
    Image image;
    LocalDate date;

    public DiaryResponseDto(Emotion emotion, String text, Image image, LocalDate date) {
        this.emotion = emotion;
        this.text = text;
        this.image = image;
        this.date = date;
    }
}

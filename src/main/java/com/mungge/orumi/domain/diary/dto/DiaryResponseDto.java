package com.mungge.orumi.domain.diary.dto;

import com.mungge.orumi.domain.Image.domain.Image;
import com.mungge.orumi.domain.diary.domain.Emotion;
import lombok.Getter;

import java.time.LocalDate;

@Getter
public class DiaryResponseDto {
    Emotion emotion;
    String text;
    String imageUrl;
    LocalDate date;

    public DiaryResponseDto(Emotion emotion, String text, LocalDate date) {
        this.emotion = emotion;
        this.text = text;
        this.date = date;
        imageUrl = null;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}

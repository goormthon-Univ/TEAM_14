package com.mungge.orumi.domain.diary.dto;

import com.mungge.orumi.domain.diary.domain.Emotion;
import lombok.Getter;

@Getter
public class DiaryRequestDto {
    private Emotion emotion;
    private String text;
}

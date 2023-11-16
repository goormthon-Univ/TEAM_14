package com.mungge.orumi.domain.diary.domain;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter @Setter
public class DiaryForm {
    private String dairyId;

    private String userId;

    private Emotion emotion;
    private String text;
    private String image;   // Image or File 엔티티 따로 구현해야할듯

    private LocalDate date;
}

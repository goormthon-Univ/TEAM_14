package com.mungge.orumi.domain.emotion.dto;

import lombok.Getter;

@Getter
public class SkyDto {
    private String userId;
    private int peace;
    private int excited;
    private int happy;
    private int tired;
    private int angry;
    private int sad;

    public SkyDto(String userId, int peace, int excited, int happy, int tired, int angry, int sad) {
        this.userId = userId;
        this.peace = peace;
        this.excited = excited;
        this.happy = happy;
        this.tired = tired;
        this.angry = angry;
        this.sad = sad;
    }
}

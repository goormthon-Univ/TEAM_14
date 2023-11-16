package com.mungge.orumi.domain.user.dto;

import lombok.Getter;

@Getter
public class MyPageDto {
    private String id;
    private String nickname;
    private int level;
    private int total;
    private int day;

    public MyPageDto(String id, String nickname, int level, int total, int day) {
        this.id = id;
        this.nickname = nickname;
        this.level = level;
        this.total = total;
        this.day = day;
    }
}

package com.mungge.orumi.domain.user.dto;

import lombok.Getter;

@Getter
public class MainDto {
    private String nickname;
    private int level;
    private boolean isWrited;

    public MainDto(String nickname, int level, boolean isWrited) {
        this.nickname = nickname;
        this.level = level;
        this.isWrited = isWrited;
    }
}

package com.mungge.orumi.domain.diary.domain;

import com.mungge.orumi.global.common.BaseEnum;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum Emotion implements BaseEnum<Integer> {
    PEACEFUL(0),
    EXCITED(1),
    HAPPY(2),
    TIRED(3),
    ANGRY(4),
    SAD(5);

    private final Integer value;

    @Override
    public Integer getValue() {
        return value;
    }
}

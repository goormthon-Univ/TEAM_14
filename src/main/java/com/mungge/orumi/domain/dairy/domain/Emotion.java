package com.mungge.orumi.domain.dairy.domain;

import com.mungge.orumi.global.common.BaseEnum;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum Emotion implements BaseEnum<Integer> {
    JOY(0),
    ANGRY(1),
    TIRED(2),
    SAD(3),
    DEPRESSED(4),
    PEACE(5);

    private final Integer value;

    @Override
    public Integer getValue() {
        return value;
    }
}

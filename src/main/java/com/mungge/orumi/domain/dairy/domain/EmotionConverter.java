package com.mungge.orumi.domain.dairy.domain;

import com.mungge.orumi.global.common.BaseEnum;
import com.mungge.orumi.global.common.BaseEnumConverter;

public class EmotionConverter extends BaseEnumConverter<Emotion, Integer> {

    @Override
    public Emotion convertToEntityAttribute(Integer dbData) {
        return BaseEnum.fromValue(dbData, Emotion.class);
    }
}

package com.mungge.orumi.global.common;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Convert;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Convert
public class LocalDateConverter implements AttributeConverter<LocalDate, String> {
    @Override
    public String convertToDatabaseColumn(LocalDate attribute) {
        if (attribute == null) {
            return "";
        } else {
            return attribute.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        }
    }

    @Override
    public LocalDate convertToEntityAttribute(String dbData) {
        if (dbData == null || dbData.isEmpty()) {
            return null;
        } else {
            return LocalDate.parse(dbData, DateTimeFormatter.ISO_LOCAL_DATE);
        }
    }
}

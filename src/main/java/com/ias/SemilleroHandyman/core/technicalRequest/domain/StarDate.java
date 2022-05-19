package com.ias.SemilleroHandyman.core.technicalRequest.domain;

import org.apache.commons.lang3.Validate;

import java.time.LocalDateTime;

public class StarDate {

    private final Integer value;

    public StarDate(Integer value) {
        Validate.notNull(value,  "StarDate date start can not be null.");


        this.value = value;
    }

    public Integer getValue() {
        return value;
    }

    @Override
    public String toString() {
        return value.toString();
    }
}

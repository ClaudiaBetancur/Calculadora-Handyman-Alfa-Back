package com.ias.SemilleroHandyman.technicalRequest.application.domain;

import org.apache.commons.lang3.Validate;

public class Id {
    private final Integer value;

    public Id(Integer value) {
        Validate.notNull(value, "La identificación no puede estar vacia");
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

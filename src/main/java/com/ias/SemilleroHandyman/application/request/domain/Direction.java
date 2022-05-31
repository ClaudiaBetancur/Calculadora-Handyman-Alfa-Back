package com.ias.SemilleroHandyman.application.request.domain;

import org.apache.commons.lang3.Validate;

public class Direction {
    private final String value;

    public Direction(String value) {
        Validate.notNull(value, "La dirección no puede ser nula");
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return value;
    }
}

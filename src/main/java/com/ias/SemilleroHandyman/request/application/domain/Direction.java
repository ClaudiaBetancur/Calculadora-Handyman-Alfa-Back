package com.ias.SemilleroHandyman.request.application.domain;

import org.apache.commons.lang3.Validate;

public class Direction {
    private final String value;

    public Direction(String value) {
        Validate.notNull(value, "Direction can not be null");
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

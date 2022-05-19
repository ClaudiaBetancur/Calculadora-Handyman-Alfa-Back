package com.ias.SemilleroHandyman.request.application.domain;

import org.apache.commons.lang3.Validate;

public class EstimatedDay {
    private final String value;

    public EstimatedDay(String value) {
        Validate.notNull(value, "Estimate can not be null");
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

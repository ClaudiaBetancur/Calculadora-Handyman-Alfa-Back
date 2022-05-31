package com.ias.SemilleroHandyman.application.request.domain;

import org.apache.commons.lang3.Validate;

public class RequestId {
    private final Integer value;

    public RequestId(Integer value) {
        Validate.notNull(value, "La identificación no puede ser nula");
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

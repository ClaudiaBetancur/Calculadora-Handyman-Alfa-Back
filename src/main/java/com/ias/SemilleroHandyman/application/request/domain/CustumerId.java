package com.ias.SemilleroHandyman.application.request.domain;

import org.apache.commons.lang3.Validate;

public class CustumerId {
    private final Integer value;

    public CustumerId(Integer value) {
        Validate.notNull(value, "El ID de cliente no puede ser nulo");
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

package com.ias.SemilleroHandyman.request.application.domain;

import org.apache.commons.lang3.Validate;

public class CustumerId {
    private final Integer value;

    public CustumerId(Integer value) {
        Validate.notNull(value, "Customer Id can not be null");
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

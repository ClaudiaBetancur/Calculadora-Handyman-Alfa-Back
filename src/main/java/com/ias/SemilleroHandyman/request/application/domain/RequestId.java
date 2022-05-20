package com.ias.SemilleroHandyman.request.application.domain;

import org.apache.commons.lang3.Validate;

public class RequestId {
    private final Integer value;

    public RequestId(Integer value) {
        Validate.notNull(value, "Id can not be null");
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

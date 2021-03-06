package com.ias.SemilleroHandyman.technicalRequest.application.domain;

import org.apache.commons.lang3.Validate;

public class TechnicalId {

    private final Integer value;

    public TechnicalId(Integer value) {
        Validate.notNull(value,  "TechnicalId identification can not be null.");

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

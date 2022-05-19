package com.ias.SemilleroHandyman.core.technicalRequest.domain;

import org.apache.commons.lang3.Validate;

public class EndDate {

    private  final Integer value;

    public EndDate(Integer value) {
        Validate.notNull(value,  "StarEnd date start can not be null.");
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

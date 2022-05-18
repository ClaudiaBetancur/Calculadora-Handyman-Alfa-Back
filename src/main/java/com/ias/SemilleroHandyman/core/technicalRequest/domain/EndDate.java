package com.ias.SemilleroHandyman.core.technicalRequest.domain;

import org.apache.commons.lang3.Validate;

import java.time.LocalDateTime;

public class EndDate {

    private  final  LocalDateTime value;

    public EndDate(LocalDateTime value) {
        Validate.notNull(value,  "StarEnd date start can not be null.");
        this.value = value;
    }

    public LocalDateTime getValue() {
        return value;
    }

    @Override
    public String toString() {
        return value.toString();
    }
}

package com.ias.SemilleroHandyman.technicalRequest.application.domain;

import org.apache.commons.lang3.Validate;

import java.time.LocalDateTime;
import java.util.Date;

public class EndDate {

    private  final LocalDateTime value;


    public EndDate(LocalDateTime value) {
        LocalDateTime localDateTime = LocalDateTime.now();
        Validate.notNull(value,  "StarEnd date start can not be null.");
        Validate.isTrue(localDateTime.isAfter(value), "the end date cannot be greater than the current date");
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

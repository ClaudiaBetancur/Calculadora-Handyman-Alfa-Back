package com.ias.SemilleroHandyman.technicalRequest.application.domain;

import org.apache.commons.lang3.Validate;

import java.time.LocalDateTime;
import java.util.Date;

public class EndDate {

    private  final LocalDateTime value;


    public EndDate(LocalDateTime value) {
        LocalDateTime localDateTime = LocalDateTime.now();
        Validate.notNull(value,  "La fecha de inicio no puede estar vacia");
        Validate.isTrue(localDateTime.isAfter(value), "la fecha de finalización no puede ser posterior a la fecha actual");
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

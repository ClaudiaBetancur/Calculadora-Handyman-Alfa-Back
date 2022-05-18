package com.ias.SemilleroHandyman.request.application.domain;

import org.apache.commons.lang3.Validate;

import java.time.LocalDateTime;

public class CreatAt {
    private final LocalDateTime value;

    public CreatAt(LocalDateTime value) {
        Validate.notNull(value, "Creat at can not be null");
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

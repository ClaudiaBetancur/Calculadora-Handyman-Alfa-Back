package com.ias.SemilleroHandyman.request.application.domain;

import org.apache.commons.lang3.Validate;

import java.time.LocalDateTime;

public class CreatAt {
    private final LocalDateTime value;

    public CreatAt(LocalDateTime value) {
        Validate.notNull(value, "La fecha de registro no puede ser nulo");
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

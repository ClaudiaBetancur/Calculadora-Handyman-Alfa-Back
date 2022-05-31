package com.ias.SemilleroHandyman.application.people.dominio;

import org.apache.commons.lang3.Validate;

public class PersonId {
    private final Integer value;

    public PersonId(Integer value) {
        Validate.notNull(value, "La identificación no puede ser nula");
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

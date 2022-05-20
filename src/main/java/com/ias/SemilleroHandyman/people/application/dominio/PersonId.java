package com.ias.SemilleroHandyman.people.application.dominio;

import org.apache.commons.lang3.Validate;

public class PersonId {
    private final Integer value;

    public PersonId(Integer value) {
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

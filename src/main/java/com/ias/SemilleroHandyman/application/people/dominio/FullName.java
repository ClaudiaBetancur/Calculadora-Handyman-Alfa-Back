package com.ias.SemilleroHandyman.application.people.dominio;

import org.apache.commons.lang3.Validate;

public class FullName {
    private final String value;

    public FullName(String value) {
        Validate.notNull(value, "El nombre completo no puede ser nulo");
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return value;
    }
}

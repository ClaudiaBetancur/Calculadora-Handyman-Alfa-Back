package com.ias.SemilleroHandyman.application.people.dominio;

import org.apache.commons.lang3.Validate;

public class Document {
    private final String value;

    public Document(String value) {
        Validate.notNull(value, "El documento no puede ser nulo");
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

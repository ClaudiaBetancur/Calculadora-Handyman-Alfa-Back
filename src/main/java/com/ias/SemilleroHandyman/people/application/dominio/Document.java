package com.ias.SemilleroHandyman.people.application.dominio;

import org.apache.commons.lang3.Validate;

public class Document {
    private final String value;

    public Document(String value) {
        Validate.notNull(value, "Document can not be null");
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

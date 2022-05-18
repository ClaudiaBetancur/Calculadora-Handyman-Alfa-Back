package com.ias.SemilleroHandyman.people.application.dominio;

import org.apache.commons.lang3.Validate;

public class FullName {
    private final String value;

    public FullName(String value) {
        Validate.notNull(value, "Full name can not be null");
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

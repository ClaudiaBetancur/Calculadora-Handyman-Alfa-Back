package com.ias.SemilleroHandyman.people.application.dominio;

import org.apache.commons.lang3.Validate;

public class TypeDocumentId {
    private final Integer value;

    public TypeDocumentId(Integer value) {
        Validate.notNull(value, "Type Document Id can not be null");
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

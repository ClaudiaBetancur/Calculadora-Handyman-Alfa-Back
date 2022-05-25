package com.ias.SemilleroHandyman.people.application.dominio;

import org.apache.commons.lang3.Validate;

public class TypeDocumentId {
    private final Integer value;

    public TypeDocumentId(Integer value) {
        Validate.notNull(value, "El tipo de identificación del documento no puede ser nulo");
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

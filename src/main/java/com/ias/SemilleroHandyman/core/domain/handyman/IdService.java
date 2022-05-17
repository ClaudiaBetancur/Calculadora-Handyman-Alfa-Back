package com.ias.SemilleroHandyman.core.domain.handyman;

import org.apache.commons.lang3.Validate;

public class IdService {

    private  final String value;

    public IdService(String value) {
        Validate.notNull(value, "Service identification can not be null.");
        Validate.isTrue(value.trim().length() == 10, "service identification must be equal to 10 characters");
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return value.toString();
    }
}
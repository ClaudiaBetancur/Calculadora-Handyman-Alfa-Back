package com.ias.SemilleroHandyman.core.domain.handyman;

import org.apache.commons.lang3.Validate;

public class IdHandyman {
    private final String value;

    public IdHandyman(String value) {
        Validate.notNull(value, "Service identification can not be null.");
        Validate.isTrue(value.trim().length() == 36, "report identification must be equal to 36 characters");
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

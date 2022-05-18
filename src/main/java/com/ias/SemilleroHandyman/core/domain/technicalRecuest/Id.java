package com.ias.SemilleroHandyman.core.domain.technicalRecuest;

import org.apache.commons.lang3.Validate;

public class Id {
    private final Integer value;

    public Id(Integer value) {
        Validate.notNull(value, "Id identification can not be null.");
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

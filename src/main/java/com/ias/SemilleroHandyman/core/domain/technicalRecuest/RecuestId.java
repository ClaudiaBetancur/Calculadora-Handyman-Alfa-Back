package com.ias.SemilleroHandyman.core.domain.technicalRecuest;

import org.apache.commons.lang3.Validate;

public class RecuestId {

    private  final Integer value;

    public RecuestId(Integer value) {
        Validate.notNull(value, "RecuestId identification can not be null.");
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

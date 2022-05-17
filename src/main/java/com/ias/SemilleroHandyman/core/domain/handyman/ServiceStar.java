package com.ias.SemilleroHandyman.core.domain.handyman;

import java.time.LocalDateTime;

public class ServiceStar {

    private final String value;

    public ServiceStar(String value) {
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

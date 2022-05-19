package com.ias.SemilleroHandyman.request.application.domain;

import org.apache.commons.lang3.Validate;

import java.time.LocalDateTime;

<<<<<<< HEAD:src/main/java/com/ias/SemilleroHandyman/core/technicalRequest/domain/StarDate.java
public class StarDate {

    private final Integer value;

    public StarDate(Integer value) {
        Validate.notNull(value,  "StarDate date start can not be null.");


=======
public class CreatAt {
    private final LocalDateTime value;

    public CreatAt(LocalDateTime value) {
        Validate.notNull(value, "Creat at can not be null");
>>>>>>> fc88f4dcc7591db7855a04b5bf97a943257c0397:src/main/java/com/ias/SemilleroHandyman/request/application/domain/CreatAt.java
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

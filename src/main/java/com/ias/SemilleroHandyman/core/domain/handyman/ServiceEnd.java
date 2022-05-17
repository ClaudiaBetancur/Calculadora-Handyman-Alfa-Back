package com.ias.SemilleroHandyman.core.domain.handyman;

public class ServiceEnd {

    private  final  String value;

    public ServiceEnd(String value) {
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

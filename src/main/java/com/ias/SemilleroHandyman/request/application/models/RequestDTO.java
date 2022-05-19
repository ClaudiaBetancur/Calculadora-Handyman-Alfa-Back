package com.ias.SemilleroHandyman.request.application.models;

import java.time.LocalDateTime;

public class RequestDTO {
    private LocalDateTime creatAt;
    private Integer customerId;
    private String direction;
    private String estimatedDay;
    private Integer id;
    private String serviceId;

    public RequestDTO() {
    }

    public RequestDTO(LocalDateTime creatAt, Integer customerId, String direction, String estimatedDay, Integer id, String serviceId) {
        this.creatAt = creatAt;
        this.customerId = customerId;
        this.direction = direction;
        this.estimatedDay = estimatedDay;
        this.id = id;
        this.serviceId = serviceId;
    }

    public LocalDateTime getCreatAt() {
        return creatAt;
    }

    public void setCreatAt(LocalDateTime creatAt) {
        this.creatAt = creatAt;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public String getEstimatedDay() {
        return estimatedDay;
    }

    public void setEstimatedDay(String estimatedDay) {
        this.estimatedDay = estimatedDay;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getServiceId() {
        return serviceId;
    }

    public void setServiceId(String serviceId) {
        this.serviceId = serviceId;
    }
}

package com.ias.SemilleroHandyman.request.application.models;

import com.ias.SemilleroHandyman.request.application.domain.*;

import java.time.LocalDateTime;

public class RequestDTO {
    private Integer id;
    private Integer serviceId;
    private Integer customerId;
    private String direction;
    private String estimatedDay;
    private LocalDateTime creatAt;

    public RequestDTO() {
    }

    public RequestDTO(Integer id, Integer serviceId, Integer customerId, String direction, String estimatedDay, LocalDateTime creatAt) {
        this.id = id;
        this.serviceId = serviceId;
        this.customerId = customerId;
        this.direction = direction;
        this.estimatedDay = estimatedDay;
        this.creatAt = creatAt;
    }

    public Request toDomain() {
        return new Request(
                new RequestId(id),
                new CustumerId(customerId),
                new ServiceId(serviceId),
                new Direction(direction),
                new EstimatedDay(estimatedDay),
                new CreatAt(creatAt)
        );
    }

    public static RequestDTO fromDomain(Request Request) {
        return new RequestDTO(
                Request.getId().getValue(),
                Request.getCustumerId().getValue(),
                Request.getServiceId().getValue(),
                Request.getDirection().getValue(),
                Request.getEstimatedDay().getValue(),
                Request.getCreatAt().getValue()
        );
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

    public Integer getServiceId() {
        return serviceId;
    }

    public void setServiceId(Integer serviceId) {
        this.serviceId = serviceId;
    }
}

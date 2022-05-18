package com.ias.SemilleroHandyman.request.application.domain;

public class Request {
    private final CreatAt creatAt;
    private final CustumerId custumerId;
    private final Direction direction;
    private final EstimatedDay estimatedDay;
    private final Id id;
    private final ServiceId serviceId;

    public Request(CreatAt creatAt, CustumerId custumerId, Direction direction, EstimatedDay estimatedDay, Id id, ServiceId serviceId) {
        this.creatAt = creatAt;
        this.custumerId = custumerId;
        this.direction = direction;
        this.estimatedDay = estimatedDay;
        this.id = id;
        this.serviceId = serviceId;
    }

    public CreatAt getCreatAt() {
        return creatAt;
    }

    public CustumerId getCustumerId() {
        return custumerId;
    }

    public Direction getDirection() {
        return direction;
    }

    public EstimatedDay getEstimatedDay() {
        return estimatedDay;
    }

    public Id getId() {
        return id;
    }

    public ServiceId getServiceId() {
        return serviceId;
    }
}

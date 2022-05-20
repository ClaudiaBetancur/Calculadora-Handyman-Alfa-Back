package com.ias.SemilleroHandyman.request.application.domain;

public class Request {
    private final RequestId id;
    private final CustumerId custumerId;
    private final ServiceId serviceId;
    private final Direction direction;
    private final EstimatedDay estimatedDay;
    private final CreatAt creatAt;

    public Request(RequestId id, CustumerId custumerId, ServiceId serviceId, Direction direction, EstimatedDay estimatedDay, CreatAt creatAt) {
        this.id = id;
        this.custumerId = custumerId;
        this.serviceId = serviceId;
        this.direction = direction;
        this.estimatedDay = estimatedDay;
        this.creatAt = creatAt;
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

    public RequestId getId() {
        return id;
    }

    public ServiceId getServiceId() {
        return serviceId;
    }
}

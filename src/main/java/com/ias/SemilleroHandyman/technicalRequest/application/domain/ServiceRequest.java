package com.ias.SemilleroHandyman.technicalRequest.application.domain;

public class ServiceRequest {

    public final Id id;
    public final TechnicalId technicalId;
    public final RequestId requestId;
    public final StarDate starDate;
    public final EndDate starEnd;

    public ServiceRequest(Id id, TechnicalId technicalId, RequestId requestId, StarDate starDate, EndDate starEnd) {
        this.id = id;
        this.technicalId = technicalId;
        this.requestId = requestId;
        this.starDate = starDate;
        this.starEnd = starEnd;
    }

    public Id getId() {
        return id;
    }

    public TechnicalId getTechnicalId() {
        return technicalId;
    }

    public RequestId getRequestId() {
        return requestId;
    }

    public StartDate getStarDate() {
        return starDate;
    }

    public EndDate getStarEnd() {
        return starEnd;
    }
}



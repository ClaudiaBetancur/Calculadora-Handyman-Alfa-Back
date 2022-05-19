package com.ias.SemilleroHandyman.technicalRequest.application.domain;

public class TechnicalRequest {

    public final Id id;
    public final TechnicalId technicalId;
    public final RequestId requestId;
    public final StartDate starDate;
    public final EndDate endDate;

    public TechnicalRequest(Id id, TechnicalId technicalId, RequestId requestId, StartDate starDate, EndDate starEnd) {
        this.id = id;
        this.technicalId = technicalId;
        this.requestId = requestId;
        this.starDate = starDate;
        this.endDate = starEnd;
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

    public EndDate getEndDate() {
        return endDate;
    }
}



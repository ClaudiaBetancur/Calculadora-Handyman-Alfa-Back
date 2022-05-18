package com.ias.SemilleroHandyman.core.technicalRequest.domain;

public class TechnicalRequest {

    public final Id id;
    public final TechnicalId technicalId;
    public final RequestId recuestId;
    public final StarDate starDate;
    public final EndDate starEnd;

    public TechnicalRequest(Id id, TechnicalId technicalId, RequestId recuestId, StarDate starDate, EndDate starEnd) {
        this.id = id;
        this.technicalId = technicalId;
        this.recuestId = recuestId;
        this.starDate = starDate;
        this.starEnd = starEnd;
    }

    public Id getId() {
        return id;
    }

    public TechnicalId getTechnicalId() {
        return technicalId;
    }

    public RequestId getRecuestId() {
        return recuestId;
    }

    public StarDate getStarDate() {
        return starDate;
    }

    public EndDate getStarEnd() {
        return starEnd;
    }
}



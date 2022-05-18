package com.ias.SemilleroHandyman.technicalRequest.application.domain;

public class TechnicalRequest {

    public final Id id;
    private final TechnicalId technicalId;
    private final RequestId recuestId;
    private final StartDate starDate;
    private final EndDate starEnd;


    public TechnicalRequest(Id id, TechnicalId technicalId, RequestId recuestId, StartDate starDate, EndDate starEnd) {
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

    public StartDate getStarDate() {
        return starDate;
    }

    public EndDate getStarEnd() {
        return starEnd;
    }
}



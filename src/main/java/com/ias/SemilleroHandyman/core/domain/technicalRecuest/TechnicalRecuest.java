package com.ias.SemilleroHandyman.core.domain.technicalRecuest;

public class TechnicalRecuest {

    public final Id id;
    public final TechnicalId technicalId;
    public final RecuestId recuestId;
    public final StarDate starDate;
    public final EndDate starEnd;

    public TechnicalRecuest(Id id, TechnicalId technicalId, RecuestId recuestId, StarDate starDate, EndDate starEnd) {
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

    public RecuestId getRecuestId() {
        return recuestId;
    }

    public StarDate getStarDate() {
        return starDate;
    }

    public EndDate getStarEnd() {
        return starEnd;
    }
}



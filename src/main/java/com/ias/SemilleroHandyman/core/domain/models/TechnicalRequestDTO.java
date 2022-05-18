package com.ias.SemilleroHandyman.core.domain.models;

public class TechnicalRequestDTO {
private Integer ID;
private Integer technicalId;
private Integer recuestId;
private Integer starDate;
private Integer starend;

    public TechnicalRequestDTO(Integer ID, Integer technicalId, Integer recuestId, Integer starDate, Integer starend) {
        this.ID = ID;
        this.technicalId = technicalId;
        this.recuestId = recuestId;
        this.starDate = starDate;
        this.starend = starend;
    }

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public Integer getTechnicalId() {
        return technicalId;
    }

    public void setTechnicalId(Integer technicalId) {
        this.technicalId = technicalId;
    }

    public Integer getRecuestId() {
        return recuestId;
    }

    public void setRecuestId(Integer recuestId) {
        this.recuestId = recuestId;
    }

    public Integer getStarDate() {
        return starDate;
    }

    public void setStarDate(Integer starDate) {
        this.starDate = starDate;
    }

    public Integer getStarend() {
        return starend;
    }

    public void setStarend(Integer starend) {
        this.starend = starend;
    }
}

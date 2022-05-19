package com.ias.SemilleroHandyman.core.technicalRequest.models;

import com.ias.SemilleroHandyman.core.technicalRequest.domain.*;

public class TechnicalRequestDTO {
    private Integer id;
    private Integer technicalId;
    private Integer recuestId;
    private Integer starDate;
    private Integer endStar;

    public TechnicalRequestDTO(Integer id, Integer technicalId, Integer recuestId, Integer starDate, Integer endStar) {
        this.id = id;
        this.technicalId = technicalId;
        this.recuestId = recuestId;
        this.starDate = starDate;
        this.endStar = endStar;
    }

    public ServiceRequest toDomain() {
        return new ServiceRequest(new Id(id),
                new TechnicalId(technicalId),
                new RequestId(recuestId),
                new StarDate(starDate),
                new EndDate(endStar)
        );
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Integer getEndStar() {
        return endStar;
    }

    public void setEndStar(Integer endStar) {
        this.endStar = endStar;
    }
}

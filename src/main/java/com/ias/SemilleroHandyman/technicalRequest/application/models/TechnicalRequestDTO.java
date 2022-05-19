package com.ias.SemilleroHandyman.technicalRequest.application.models;

import com.ias.SemilleroHandyman.technicalRequest.application.domain.*;

import java.time.LocalDateTime;

public class TechnicalRequestDTO {
    private Integer id;
    private Integer technicalId;
    private Integer recuestId;
    private LocalDateTime startDate;
    private LocalDateTime endDate;

    public TechnicalRequestDTO() {
    }

    public TechnicalRequestDTO(Integer id, Integer technicalId, Integer recuestId, LocalDateTime startDate, LocalDateTime endDate) {
        this.id = id;
        this.technicalId = technicalId;
        this.recuestId = recuestId;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public TechnicalRequest toDomain() {
        return new TechnicalRequest(new Id(id),
                new TechnicalId(technicalId),
                new RequestId(recuestId),
                new StartDate(startDate),
                new EndDate(endDate)
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

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }
}

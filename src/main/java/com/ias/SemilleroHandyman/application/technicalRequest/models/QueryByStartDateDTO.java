package com.ias.SemilleroHandyman.application.technicalRequest.models;

import java.time.LocalDateTime;

public class QueryByStartDateDTO {

    private String typeFilter;
    private String identification;
    private LocalDateTime startDate;
    private LocalDateTime endDate;

    public QueryByStartDateDTO(String typeFilter, String identification, LocalDateTime startDate, LocalDateTime endDate) {
        this.typeFilter = typeFilter;
        this.identification = identification;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public String getTypeFilter() {
        return typeFilter;
    }

    public void setTypeFilter(String typeFilter) {
        this.typeFilter = typeFilter;
    }

    public String getIdentification() {
        return identification;
    }

    public void setIdentification(String identification) {
        this.identification = identification;
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

package com.ias.SemilleroHandyman.technicalRequest.application.models;

import com.ias.SemilleroHandyman.people.application.dominio.People;
import com.ias.SemilleroHandyman.people.application.models.PeopleDTO;
import com.ias.SemilleroHandyman.technicalRequest.application.domain.*;

import java.time.LocalDateTime;

public class TechnicalRequestDTO {
    private Integer id;
    private Integer technicalId;
    private String document;
    private Integer requestId;
    private LocalDateTime startDate;
    private LocalDateTime endDate;

    public TechnicalRequestDTO(Integer id, String document, Integer requestId, LocalDateTime startDate, LocalDateTime endDate) {
        this.id = id;
        this.document = document;
        this.requestId = requestId;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public TechnicalRequest toDomain() {
        return new TechnicalRequest(
                new Id(id),
                new TechnicalId(technicalId),
                new RequestId(requestId),
                new StartDate(startDate),
                new EndDate(endDate)
        );
    }

    public static TechnicalRequestDTO fromDomain(TechnicalRequest technicalRequest) {
        return new TechnicalRequestDTO(
                technicalRequest.getId().getValue(),
                technicalRequest.getTechnicalId().getValue().toString(),
                technicalRequest.getRequestId().getValue(),
                technicalRequest.getStarDate().getValue(),
                technicalRequest.getEndDate().getValue()
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

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public Integer getRequestId() {
        return requestId;
    }

    public void setRequestId(Integer recuestId) {
        this.requestId = recuestId;
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

    @Override
    public String toString() {
        return "{" +
                "id=" + id +
                ", technicalId=" + technicalId +
                ", document='" + document + '\'' +
                ", requestId=" + requestId +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                '}';
    }
}

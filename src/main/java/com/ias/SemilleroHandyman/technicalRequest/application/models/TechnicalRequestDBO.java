package com.ias.SemilleroHandyman.technicalRequest.application.models;

import com.ias.SemilleroHandyman.technicalRequest.application.domain.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

public class TechnicalRequestDBO {
    private Integer id;
    private Integer technicalId;
    private Integer requestId;
    private LocalDateTime startDate;
    private LocalDateTime endDate;

    public TechnicalRequestDBO() {
    }

    public TechnicalRequestDBO(Integer id, Integer technicalId, Integer requestId, LocalDateTime startDate, LocalDateTime endDate) {
        this.id = id;
        this.technicalId = technicalId;
        this.requestId = requestId;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public static TechnicalRequestDBO fromResultSet(ResultSet resultSet) throws SQLException {
        TechnicalRequestDBO technicalRequestDBO = new TechnicalRequestDBO();

        technicalRequestDBO.setId(resultSet.getInt("id"));
        technicalRequestDBO.setTechnicalId(resultSet.getInt("technical_id"));
        technicalRequestDBO.setRequestId((resultSet.getInt("request_id")));
        technicalRequestDBO.setStartDate(resultSet.getTimestamp("start_date").toLocalDateTime());
        technicalRequestDBO.setEndDate(resultSet.getTimestamp("end_date").toLocalDateTime());

        return technicalRequestDBO;
    }

    public TechnicalRequest toDomain() {
        return new TechnicalRequest(new Id(id),
                new TechnicalId(technicalId),
                new RequestId(requestId),
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

    public Integer getRequestId() {
        return requestId;
    }

    public void setRequestId(Integer requestId) {
        this.requestId = requestId;
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

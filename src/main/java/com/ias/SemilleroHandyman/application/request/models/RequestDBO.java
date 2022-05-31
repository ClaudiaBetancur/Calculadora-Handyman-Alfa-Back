package com.ias.SemilleroHandyman.application.request.models;

import com.ias.SemilleroHandyman.application.people.dominio.*;
import com.ias.SemilleroHandyman.application.request.domain.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

public class RequestDBO {

    private Integer id;
    private Integer serviceId;
    private Integer customerId;
    private String direction;
    private String estimatedDay;
    private LocalDateTime creatAt;

    public RequestDBO() {
    }

    public RequestDBO(Integer id, Integer serviceId, Integer customerId, String direction, String estimatedDay, LocalDateTime creatAt) {
        this.id = id;
        this.serviceId = serviceId;
        this.customerId = customerId;
        this.direction = direction;
        this.estimatedDay = estimatedDay;
        this.creatAt = creatAt;
    }

    public static RequestDBO fromResultSet(ResultSet resultSet) throws SQLException {
        RequestDBO requestRequestDBO = new RequestDBO();

        requestRequestDBO.setId(resultSet.getInt("id"));
        requestRequestDBO.setCustomerId(resultSet.getInt("customer_id"));
        requestRequestDBO.setServiceId((resultSet.getInt("service_id")));
        requestRequestDBO.setDirection(resultSet.getString("direction"));
        requestRequestDBO.setEstimatedDay(resultSet.getString("estimated_day"));
        requestRequestDBO.setCreatAt(resultSet.getTimestamp("creat_at").toLocalDateTime());

        return requestRequestDBO;
    }

    public Request toDomain() {
        return new Request(
                new RequestId(id),
                new CustumerId(customerId),
                new ServiceId(serviceId),
                new Direction(direction),
                new EstimatedDay(estimatedDay),
                new CreatAt(creatAt)
        );
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getServiceId() {
        return serviceId;
    }

    public void setServiceId(Integer serviceId) {
        this.serviceId = serviceId;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public String getEstimatedDay() {
        return estimatedDay;
    }

    public void setEstimatedDay(String estimatedDay) {
        this.estimatedDay = estimatedDay;
    }

    public LocalDateTime getCreatAt() {
        return creatAt;
    }

    public void setCreatAt(LocalDateTime creatAt) {
        this.creatAt = creatAt;
    }
}
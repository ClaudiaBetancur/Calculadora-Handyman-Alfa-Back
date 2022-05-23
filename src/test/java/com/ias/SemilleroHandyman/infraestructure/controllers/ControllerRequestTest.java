package com.ias.SemilleroHandyman.infraestructure.controllers;

import com.ias.SemilleroHandyman.infraestructure.adapters.out.Pg_TechnicalRequestRepository;
import com.ias.SemilleroHandyman.technicalRequest.application.domain.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class ControllerRequestTest {

    @Autowired
    Pg_TechnicalRequestRepository pg_TechnicalRequestRepository;

    @Test
    void create() {
        Id id = new Id(0);
        RequestId requestId = new RequestId(1);
        TechnicalId technicalId = new TechnicalId(1);
        StartDate startDate = new StartDate(LocalDateTime.parse("2022-05-18T13:24:30."));
        EndDate endDate = new EndDate(LocalDateTime.parse("2022-05-19T13:24:30."));
        TechnicalRequest technicalRequest = new TechnicalRequest(
                id,
                technicalId,
                requestId,
                startDate,
                endDate
        );

        //assertTrue(IdGenerate > 0);
    }

    @Test
    void handleException() {
    }
}
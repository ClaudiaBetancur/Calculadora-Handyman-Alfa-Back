package com.ias.SemilleroHandyman.infraestructure.adapters.out;

import com.ias.SemilleroHandyman.application.technicalRequest.domain.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ActiveProfiles("test")
class Pg_TechnicalRequestRepositoryTest {

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

        int IdGenerate = pg_TechnicalRequestRepository.create(technicalRequest);

        assertTrue(IdGenerate > 0);
    }

    @Test
    void getByDateRange() {
        //LocalDateTime localDateTimeStart = new LocalDateTime("2022-05-18T13:24:30.");
        //DateRange dateRange = new DateRange()
    }
}
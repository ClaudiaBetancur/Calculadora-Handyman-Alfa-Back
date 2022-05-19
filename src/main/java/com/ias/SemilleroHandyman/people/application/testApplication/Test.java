package com.ias.SemilleroHandyman.people.application.testApplication;

import com.ias.SemilleroHandyman.technicalRequest.application.domain.*;

import java.time.LocalDateTime;

public class Test {
    public static void main(String[] args) {
        Id id = new Id(1);
        RequestId recuestId = new RequestId(123456789);
        TechnicalId technicalId = new TechnicalId(1876543221);
        StartDate starDate = new StartDate(LocalDateTime.parse("2007-12-03T10:15:30."));
        EndDate endDate = new EndDate(LocalDateTime.parse("2007-12-03T10:16:30."));
        TechnicalRequest technicalRecuest = new TechnicalRequest(id,technicalId,recuestId,starDate,endDate);
    }
}

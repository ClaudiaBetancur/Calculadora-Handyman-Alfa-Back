package com.ias.SemilleroHandyman.testApplication;

import com.ias.SemilleroHandyman.core.domain.technicalRecuest.*;

import java.time.LocalDateTime;

public class Test {
    public static void main(String[] args) {
        Id id = new Id(1);
        RecuestId recuestId = new RecuestId(123456789);
        TechnicalId technicalId = new TechnicalId(1876543221);
        StarDate starDate = new StarDate(LocalDateTime.parse("2007-12-03T10:15:30."));
        EndDate endDate = new EndDate(LocalDateTime.parse("2007-12-03T10:16:30."));
        TechnicalRecuest technicalRecuest = new TechnicalRecuest(id,technicalId,recuestId,starDate,endDate);
    }
}

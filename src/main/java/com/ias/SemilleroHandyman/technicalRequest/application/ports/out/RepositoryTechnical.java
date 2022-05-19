package com.ias.SemilleroHandyman.technicalRequest.application.ports.out;

import com.ias.SemilleroHandyman.technicalRequest.application.domain.TechnicalRequest;

public interface RepositoryTechnical {
    void create(TechnicalRequest technicalRequest);
}

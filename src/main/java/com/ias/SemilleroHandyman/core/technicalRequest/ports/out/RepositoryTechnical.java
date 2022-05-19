package com.ias.SemilleroHandyman.core.technicalRequest.ports.out;

import com.ias.SemilleroHandyman.core.technicalRequest.domain.ServiceRequest;

public interface RepositoryTechnical {
    void create(ServiceRequest serviceRequest);
}

package com.ias.SemilleroHandyman.core.technicalRequest.servicesDomain;

import com.ias.SemilleroHandyman.core.technicalRequest.domain.ServiceRequest;
import com.ias.SemilleroHandyman.core.technicalRequest.models.TechnicalRequestDTO;
import com.ias.SemilleroHandyman.core.technicalRequest.ports.in.CreatRequestUseCase;
import com.ias.SemilleroHandyman.core.technicalRequest.ports.out.RepositoryTechnical;

public class CreadRequestService implements CreatRequestUseCase {

    private final RepositoryTechnical repositoryTechnical;

    public CreadRequestService(RepositoryTechnical repositoryTechnical) {
        this.repositoryTechnical = repositoryTechnical;
    }

    @Override
    public TechnicalRequestDTO excute(TechnicalRequestDTO technicalRequestDTO) {


        return null;
    }
}

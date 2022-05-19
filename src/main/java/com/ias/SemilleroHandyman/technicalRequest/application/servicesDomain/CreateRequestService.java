package com.ias.SemilleroHandyman.technicalRequest.application.servicesDomain;

import com.ias.SemilleroHandyman.technicalRequest.application.domain.TechnicalRequest;
import com.ias.SemilleroHandyman.technicalRequest.application.ports.in.CreateRequestUseCase;
import com.ias.SemilleroHandyman.technicalRequest.application.models.TechnicalRequestDTO;
import com.ias.SemilleroHandyman.technicalRequest.application.ports.out.RepositoryTechnical;
import org.springframework.stereotype.Service;

@Service
public class CreateRequestService implements CreateRequestUseCase {

    private final RepositoryTechnical repositoryTechnical;

    public CreateRequestService(RepositoryTechnical repositoryTechnical) {
        this.repositoryTechnical = repositoryTechnical;
    }

    @Override
    public TechnicalRequestDTO excute(TechnicalRequestDTO technicalRequestDTO) {

        TechnicalRequest technicalRequest = technicalRequestDTO.toDomain();
        repositoryTechnical.create (technicalRequest);
        return null;
    }

}

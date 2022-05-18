package com.ias.SemilleroHandyman.core.technicalRequest.servicesDomain;

import com.ias.SemilleroHandyman.core.technicalRequest.models.TechnicalRequestDTO;
import com.ias.SemilleroHandyman.core.technicalRequest.ports.in.CreatRecuestUseCase;
import com.ias.SemilleroHandyman.core.technicalRequest.ports.out.TechnicalRepository;

public class CreadRecuestService implements CreatRecuestUseCase {

    private final TechnicalRepository technicalRepository;

    public CreadRecuestService(TechnicalRepository technicalRepository) {
        this.technicalRepository = technicalRepository;
    }

    @Override
    public TechnicalRequestDTO excute(TechnicalRequestDTO technicalRequestDTO) {
        return null;
    }
}

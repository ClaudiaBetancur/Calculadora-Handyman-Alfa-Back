package com.ias.SemilleroHandyman.core.domain.servicesDomain;

import com.ias.SemilleroHandyman.core.domain.models.TechnicalRequestDTO;
import com.ias.SemilleroHandyman.core.domain.ports.in.CreatRecuestUseCase;
import com.ias.SemilleroHandyman.core.domain.ports.out.TechnicalRepository;

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

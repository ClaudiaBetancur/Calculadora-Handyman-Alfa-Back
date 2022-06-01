package com.ias.SemilleroHandyman.application.technicalRequest.ports.out;

import com.ias.SemilleroHandyman.application.technicalRequest.domain.TechnicalRequest;
import com.ias.SemilleroHandyman.application.technicalRequest.models.QueryByStartDate;
import com.ias.SemilleroHandyman.application.technicalRequest.models.TechnicalRequestDTO;
import com.ias.SemilleroHandyman.sharedDomain.models.DateRange;

import java.util.ArrayList;
import java.util.Optional;

public interface RepositoryTechnicalRequest {
    Integer create(TechnicalRequest technicalRequest);
    Optional<TechnicalRequest> getByDateRange(DateRange dateRange);
    ArrayList<TechnicalRequestDTO> getByStartDate(QueryByStartDate queryByStartDateDTO);
}

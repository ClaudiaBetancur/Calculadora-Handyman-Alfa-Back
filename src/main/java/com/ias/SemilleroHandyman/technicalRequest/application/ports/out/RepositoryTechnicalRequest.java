package com.ias.SemilleroHandyman.technicalRequest.application.ports.out;

import com.ias.SemilleroHandyman.request.application.domain.Request;
import com.ias.SemilleroHandyman.request.application.domain.RequestId;
import com.ias.SemilleroHandyman.sharedDomain.models.DateRange;
import com.ias.SemilleroHandyman.technicalRequest.application.domain.TechnicalRequest;
import com.ias.SemilleroHandyman.technicalRequest.application.models.QueryByStartDateDTO;

import java.time.LocalDateTime;
import java.util.Optional;

public interface RepositoryTechnicalRequest {
    Integer create(TechnicalRequest technicalRequest);
    Optional<TechnicalRequest> getByDateRange(DateRange dateRange);
    Optional<TechnicalRequest> getByStartDate(QueryByStartDateDTO queryByStartDateDTO);
}

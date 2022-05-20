package com.ias.SemilleroHandyman.technicalRequest.application.ports.in;


import com.ias.SemilleroHandyman.commons.UseCase;
import com.ias.SemilleroHandyman.request.application.models.RequestDTO;
import com.ias.SemilleroHandyman.sharedDomain.models.DateRange;

import java.util.Optional;

public interface QueryTechnicalRequestByRangeDateUseCase extends UseCase<DateRange, Optional<RequestDTO>> {
}

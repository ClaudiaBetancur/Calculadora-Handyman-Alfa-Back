package com.ias.SemilleroHandyman.technicalRequest.application.ports.in;


import com.ias.SemilleroHandyman.commons.UseCase;
import com.ias.SemilleroHandyman.technicalRequest.application.models.QueryByStartDateDTO;
import com.ias.SemilleroHandyman.technicalRequest.application.models.TechnicalRequestDTO;

import java.util.ArrayList;

public interface QueryTechnicalRequestUseCase extends UseCase<QueryByStartDateDTO, ArrayList<TechnicalRequestDTO>> {
}

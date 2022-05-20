package com.ias.SemilleroHandyman.request.application.ports.in;


import com.ias.SemilleroHandyman.commons.UseCase;
import com.ias.SemilleroHandyman.request.application.models.RequestDTO;

import java.util.Optional;

public interface QueryRequestUseCase extends UseCase<Integer, Optional<RequestDTO>> {
}

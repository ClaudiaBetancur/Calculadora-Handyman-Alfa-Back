package com.ias.SemilleroHandyman.application.request.ports.in;


import com.ias.SemilleroHandyman.application.request.models.RequestDTO;
import com.ias.SemilleroHandyman.commons.UseCase;

import java.util.Optional;

public interface QueryRequestUseCase extends UseCase<Integer, Optional<RequestDTO>> {
}

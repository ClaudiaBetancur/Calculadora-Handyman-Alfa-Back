package com.ias.SemilleroHandyman.people.application.ports.in;

import com.ias.SemilleroHandyman.commons.UseCase;
import com.ias.SemilleroHandyman.people.application.models.PeopleDTO;

import java.util.Optional;

public interface QueryPersonByIdUseCase extends UseCase<Integer, Optional<PeopleDTO>> {
}

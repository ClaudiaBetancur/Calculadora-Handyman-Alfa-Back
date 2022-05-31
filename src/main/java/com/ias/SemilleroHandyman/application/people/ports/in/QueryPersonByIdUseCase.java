package com.ias.SemilleroHandyman.application.people.ports.in;

import com.ias.SemilleroHandyman.commons.UseCase;
import com.ias.SemilleroHandyman.application.people.models.PeopleDTO;

import java.util.Optional;

public interface QueryPersonByIdUseCase extends UseCase<Integer, Optional<PeopleDTO>> {
}

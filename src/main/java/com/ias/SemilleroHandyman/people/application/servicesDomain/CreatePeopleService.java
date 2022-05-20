package com.ias.SemilleroHandyman.people.application.servicesDomain;

import com.ias.SemilleroHandyman.people.application.models.PeopleDTO;
import com.ias.SemilleroHandyman.people.application.ports.in.CreatePeopleUseCase;
import com.ias.SemilleroHandyman.people.application.ports.out.PeopleRepository;
import com.ias.SemilleroHandyman.technicalRequest.application.models.TechnicalRequestDTO;

public class CreatePeopleService implements CreatePeopleUseCase {

    private final PeopleRepository peopleRepository;

    public CreatePeopleService(PeopleRepository peopleRepository) {
        this.peopleRepository = peopleRepository;
    }

    @Override
    public PeopleDTO excute(PeopleDTO peopleDTO) {
        return null;
    }
}

package com.ias.SemilleroHandyman.application.people.servicesDomain;

import com.ias.SemilleroHandyman.application.people.models.PeopleDTO;
import com.ias.SemilleroHandyman.application.people.ports.in.CreatePeopleUseCase;
import com.ias.SemilleroHandyman.application.people.ports.out.PeopleRepository;

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

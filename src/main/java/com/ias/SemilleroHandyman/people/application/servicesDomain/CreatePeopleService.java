package com.ias.SemilleroHandyman.people.application.servicesDomain;

import com.ias.SemilleroHandyman.people.application.ports.in.CreatePeopleUseCase;

public class CreatePeopleService implements CreatePeopleUseCase {

    private final CreatePeopleService createPeopleService;

    public CreatePeopleService(CreatePeopleService createPeopleService) {
        this.createPeopleService = createPeopleService;
    }


}

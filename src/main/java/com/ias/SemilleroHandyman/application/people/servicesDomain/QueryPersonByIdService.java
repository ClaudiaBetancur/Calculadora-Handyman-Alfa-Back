package com.ias.SemilleroHandyman.application.people.servicesDomain;

import com.ias.SemilleroHandyman.application.people.dominio.*;
import com.ias.SemilleroHandyman.application.people.models.PeopleDTO;
import com.ias.SemilleroHandyman.application.people.ports.in.QueryPersonByIdUseCase;
import com.ias.SemilleroHandyman.application.people.ports.out.PeopleRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class QueryPersonByIdService implements QueryPersonByIdUseCase {

    private final PeopleRepository peopleRepository;

    public QueryPersonByIdService(PeopleRepository peopleRepository) {
        this.peopleRepository = peopleRepository;
    }

    @Override
    public Optional<PeopleDTO> excute(Integer personId) {
        Optional<People> people = peopleRepository.getPersonById(new PersonId(personId));
        return people.map(people1 -> {
            PeopleDTO peopleDTO = PeopleDTO.fromDomain(people1);
            return peopleDTO;
        });
    }

}

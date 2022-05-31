package com.ias.SemilleroHandyman.application.people.servicesDomain;

import com.ias.SemilleroHandyman.application.people.dominio.*;
import com.ias.SemilleroHandyman.application.people.models.PeopleDTO;
import com.ias.SemilleroHandyman.application.people.ports.in.QueryPersonByDocumentUseCase;
import com.ias.SemilleroHandyman.application.people.ports.out.PeopleRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class QueryPersonByDocumentService implements QueryPersonByDocumentUseCase {

    private final PeopleRepository peopleRepository;

    public QueryPersonByDocumentService(PeopleRepository peopleRepository) {
        this.peopleRepository = peopleRepository;
    }

    @Override
    public Optional<PeopleDTO> excute(String document) {
        Optional<People> people = peopleRepository.getPersonByDocument(new Document(document));
        return people.map(people1 -> {
            PeopleDTO peopleDTO = PeopleDTO.fromDomain(people1);
            return peopleDTO;
        });
    }

}

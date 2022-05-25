package com.ias.SemilleroHandyman.people.application.servicesDomain;

import com.ias.SemilleroHandyman.people.application.dominio.Document;
import com.ias.SemilleroHandyman.people.application.dominio.People;
import com.ias.SemilleroHandyman.people.application.models.PeopleDTO;
import com.ias.SemilleroHandyman.people.application.ports.in.QueryPersonByDocumentUseCase;
import com.ias.SemilleroHandyman.people.application.ports.out.PeopleRepository;
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

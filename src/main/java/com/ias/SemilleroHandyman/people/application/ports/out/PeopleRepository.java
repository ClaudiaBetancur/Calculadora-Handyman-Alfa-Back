package com.ias.SemilleroHandyman.people.application.ports.out;

import com.ias.SemilleroHandyman.people.application.dominio.Document;
import com.ias.SemilleroHandyman.people.application.dominio.People;
import com.ias.SemilleroHandyman.technicalRequest.application.domain.TechnicalRequest;

import java.util.Optional;

public interface PeopleRepository {
    void create(People people);
    Optional<People> getPersonByDocument(Document document);
}

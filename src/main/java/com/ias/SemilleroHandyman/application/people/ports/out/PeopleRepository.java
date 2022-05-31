package com.ias.SemilleroHandyman.application.people.ports.out;

import com.ias.SemilleroHandyman.application.people.dominio.*;

import java.util.Optional;

public interface PeopleRepository {
    void create(People people);
    Optional<People> getPersonById(PersonId personId);
    Optional<People> getPersonByDocument(Document document);
}

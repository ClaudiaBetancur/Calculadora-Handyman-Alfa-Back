package com.ias.SemilleroHandyman.people.application.models;

import com.ias.SemilleroHandyman.people.application.dominio.Document;
import com.ias.SemilleroHandyman.people.application.dominio.FullName;
import com.ias.SemilleroHandyman.people.application.dominio.PersonId;
import com.ias.SemilleroHandyman.people.application.dominio.People;
import com.ias.SemilleroHandyman.people.application.dominio.TypeDocumentId;

public class PeopleDTO {
    private String document;
    private String fullName;
    private Integer id;
    private Integer typeDocumentId;

    public PeopleDTO() {
    }

    public PeopleDTO(String document, String fullName, Integer id, Integer typeDocumentId) {
        this.document = document;
        this.fullName = fullName;
        this.id = id;
        this.typeDocumentId = typeDocumentId;
    }

    public People toDomain() {
        return new People(
                new PersonId(id),
                new TypeDocumentId(typeDocumentId),
                new Document(document),
                new FullName(fullName)
        );
    }

    public static PeopleDTO fromDomain(People person) {
        return new PeopleDTO(
                person.getDocument().getValue(),
                person.getFullName().getValue(),
                person.getId().getValue(),
                person.getTypeDocumentId().getValue()
        );
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTypeDocumentId() {
        return typeDocumentId;
    }

    public void setTypeDocumentId(Integer typeDocumentId) {
        this.typeDocumentId = typeDocumentId;
    }

    @Override
    public String toString() {
        return "\"person\":{" +
                "\"document\":\"" + document + "\"" +
                ", \"fullName\":\"" + fullName + "\"" +
                ", \"id\":" + id +
                ", \"typeDocumentId\":" + typeDocumentId +
                '}';
    }
}

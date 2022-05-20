package com.ias.SemilleroHandyman.people.application.dominio;

public class People {

    private final PersonId id;
    private final TypeDocumentId typeDocumentId;
    private final Document document;
    private final FullName fullName;

    public People(PersonId id, TypeDocumentId typeDocumentId, Document document, FullName fullName) {
        this.id = id;
        this.typeDocumentId = typeDocumentId;
        this.document = document;
        this.fullName = fullName;
    }

    public PersonId getId() {
        return id;
    }

    public TypeDocumentId getTypeDocumentId() {
        return typeDocumentId;
    }

    public Document getDocument() {
        return document;
    }

    public FullName getFullName() {
        return fullName;
    }
}

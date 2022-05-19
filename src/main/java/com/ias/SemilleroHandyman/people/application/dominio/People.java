package com.ias.SemilleroHandyman.people.application.dominio;

public class People {

    private final Id id;
    private final TypeDocumentId typeDocumentId;
    private final Document document;
    private final FullName fullName;

    public People(Id id, TypeDocumentId typeDocumentId, Document document, FullName fullName) {
        this.id = id;
        this.typeDocumentId = typeDocumentId;
        this.document = document;
        this.fullName = fullName;
    }

    public Id getId() {
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

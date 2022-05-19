package com.ias.SemilleroHandyman.people.application.models;

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
}

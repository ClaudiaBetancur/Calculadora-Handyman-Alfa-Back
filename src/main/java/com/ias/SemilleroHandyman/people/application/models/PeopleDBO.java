package com.ias.SemilleroHandyman.people.application.models;

import com.ias.SemilleroHandyman.people.application.dominio.*;
import com.ias.SemilleroHandyman.people.application.dominio.PersonId;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PeopleDBO {
    private Integer id;
    private String document;
    private String fullName;
    private Integer typeDocumentId;

    public PeopleDBO() {
    }

    public PeopleDBO(Integer id, String document, String fullName, Integer typeDocumentId) {
        this.id = id;
        this.document = document;
        this.fullName = fullName;
        this.typeDocumentId = typeDocumentId;
    }

    public static PeopleDBO fromResultSet(ResultSet resultSet) throws SQLException {
        PeopleDBO peopleRequestDBO = new PeopleDBO();

        peopleRequestDBO.setId(resultSet.getInt("id"));
        peopleRequestDBO.setDocument(resultSet.getString("document"));
        peopleRequestDBO.setFullName((resultSet.getString("fullname")));
        peopleRequestDBO.setTypeDocumentId(resultSet.getInt("type_document_id"));

        return peopleRequestDBO;
    }

    public People toDomain() {
        return new People(
                new PersonId(id),
                new TypeDocumentId(typeDocumentId),
                new Document(document),
                new FullName(fullName)
        );
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Integer getTypeDocumentId() {
        return typeDocumentId;
    }

    public void setTypeDocumentId(Integer typeDocumentId) {
        this.typeDocumentId = typeDocumentId;
    }
}

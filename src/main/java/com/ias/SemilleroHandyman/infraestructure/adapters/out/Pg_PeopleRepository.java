package com.ias.SemilleroHandyman.infraestructure.adapters.out;

import com.ias.SemilleroHandyman.application.people.dominio.*;
import com.ias.SemilleroHandyman.application.people.models.PeopleDBO;
import com.ias.SemilleroHandyman.application.people.ports.out.PeopleRepository;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

@Repository
public class Pg_PeopleRepository implements PeopleRepository {

    private final DataSource dataSource;

    public Pg_PeopleRepository(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public void create(People people) {

    }

    @Override
    public Optional<People> getPersonById(PersonId personId) {
        String columnaFilter = "id";
        return getPerson(columnaFilter, personId.getValue().toString());
    }

    @Override
    public Optional<People> getPersonByDocument(Document document) {
        String columnaFilter = "document";
        return getPerson(columnaFilter, document.getValue());
    }

    private Optional<People> getPerson(String columnaFilter, String value){
        String sql = "Select * From people Where " + columnaFilter + " = ?";
        try(Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            if(columnaFilter.equals("document")){
                preparedStatement.setString(1, value);
            }else{
                preparedStatement.setInt(1, Integer.parseInt(value));
            }
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                PeopleDBO peopleDBO = PeopleDBO.fromResultSet(resultSet);
                People people = peopleDBO.toDomain();
                return Optional.of(people);
            } else {
                return Optional.empty();
            }
        }catch (SQLException exception) {
            throw new RuntimeException("Error querying database", exception);
        }
    }


}

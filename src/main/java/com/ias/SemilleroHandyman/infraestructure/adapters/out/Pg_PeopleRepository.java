package com.ias.SemilleroHandyman.infraestructure.adapters.out;

import com.ias.SemilleroHandyman.people.application.dominio.Document;
import com.ias.SemilleroHandyman.people.application.dominio.People;
import com.ias.SemilleroHandyman.people.application.models.PeopleDBO;
import com.ias.SemilleroHandyman.people.application.ports.out.PeopleRepository;
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
    public Optional<People> getPersonByDocument(Document document) {
        String sql = "Select * From people Where document = ?";
        try(Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, document.getValue());
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

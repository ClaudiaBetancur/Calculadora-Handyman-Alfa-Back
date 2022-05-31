package com.ias.SemilleroHandyman.infraestructure.adapters.out;
import com.ias.SemilleroHandyman.application.request.domain.Request;
import com.ias.SemilleroHandyman.application.request.domain.RequestId;
import com.ias.SemilleroHandyman.application.request.models.RequestDBO;
import com.ias.SemilleroHandyman.application.request.ports.out.RequestRepository;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

@Repository
public class Pg_RequestRepository implements RequestRepository {

    private final DataSource dataSource;

    public Pg_RequestRepository(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public void store(Request request) {

    }

    @Override
    public Optional<Request> get(RequestId requestId) {
        String sql = "Select * From request Where id = ?";
        try(Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, requestId.getValue());
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                RequestDBO requestDBO = RequestDBO.fromResultSet(resultSet);
                Request request = requestDBO.toDomain();
                return Optional.of(request);
            } else {
                return Optional.empty();
            }
        }catch (SQLException exception) {
            throw new RuntimeException("Error querying database", exception);
        }
    }
}

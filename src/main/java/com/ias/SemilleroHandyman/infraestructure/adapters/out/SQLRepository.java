package com.ias.SemilleroHandyman.infraestructure.adapters.out;

import com.ias.SemilleroHandyman.technicalRequest.application.domain.TechnicalRequest;
import com.ias.SemilleroHandyman.technicalRequest.application.ports.out.RepositoryTechnical;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;

@Repository
public class SQLRepository implements RepositoryTechnical {

    private final DataSource dataSource;

    public SQLRepository(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public void create(TechnicalRequest technicalRequest) {
        String sql = "INSERT INTO ServiceRequest (id,technical_id,request_id,start_date,end_date) VALUES (?, ?, ?, ?, ?)";

        try(Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setLong(1,technicalRequest. getId().getValue());
            preparedStatement.setLong(2, technicalRequest.getTechnicalId().getValue());
            preparedStatement.setInt(3, technicalRequest.getRequestId().getValue());
            preparedStatement.setTimestamp(4, Timestamp.valueOf(technicalRequest.getStarDate().toString()));
            preparedStatement.setTimestamp(5, Timestamp.valueOf(technicalRequest.getEndDate().toString()));
            preparedStatement.executeUpdate();

        } catch (SQLException exception) {
            throw new RuntimeException("Error querying database " + exception.getMessage(),  exception);
        }
    }
}


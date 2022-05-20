package com.ias.SemilleroHandyman.infraestructure.adapters.out;

import com.ias.SemilleroHandyman.sharedDomain.models.DateRange;
import com.ias.SemilleroHandyman.technicalRequest.application.domain.TechnicalRequest;
import com.ias.SemilleroHandyman.technicalRequest.application.models.TechnicalRequestDBO;
import com.ias.SemilleroHandyman.technicalRequest.application.ports.out.RepositoryTechnicalRequest;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.*;
import java.util.Optional;

@Repository
public class Pg_TechnicalRequestRepository implements RepositoryTechnicalRequest {

    private final DataSource dataSource;

    public Pg_TechnicalRequestRepository(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public void create(TechnicalRequest technicalRequest) {
        String sql = "INSERT INTO technicals_x_requests (technical_id,request_id,start_date,end_date) VALUES (?, ?, ?, ?)";

        try(Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            //preparedStatement.setInt(1,technicalRequest. getId().getValue());
            preparedStatement.setInt(1, technicalRequest.getTechnicalId().getValue());
            preparedStatement.setInt(2, technicalRequest.getRequestId().getValue());
            preparedStatement.setTimestamp(3, Timestamp.valueOf(technicalRequest.getStarDate().getValue()));
            preparedStatement.setTimestamp(4, Timestamp.valueOf(technicalRequest.getEndDate().getValue()));
            preparedStatement.execute();

        } catch (SQLException exception) {
            throw new RuntimeException("Error querying database " + exception.getMessage(),  exception);
        }
    }

    @Override
    public Optional<TechnicalRequest> getByDateRange(DateRange dateRange) {
        String sql = "Select * From technicals_x_requests Where start_date BETWEEN ? AND ? AND end_date BETWEEN ? AND ?";
        try(Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setTimestamp(1,Timestamp.valueOf(dateRange.getStartDate()));
            preparedStatement.setTimestamp(2,Timestamp.valueOf(dateRange.getEndDate()));
            preparedStatement.setTimestamp(3,Timestamp.valueOf(dateRange.getStartDate()));
            preparedStatement.setTimestamp(4,Timestamp.valueOf(dateRange.getEndDate()));
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                TechnicalRequestDBO technicalRequestDBO = TechnicalRequestDBO.fromResultSet(resultSet);
                TechnicalRequest technicalRequest = technicalRequestDBO.toDomain();
                return Optional.of(technicalRequest);
            } else {
                return Optional.empty();
            }

        }catch (SQLException exception) {
            throw new RuntimeException("Error querying database", exception);
        }
    }
}


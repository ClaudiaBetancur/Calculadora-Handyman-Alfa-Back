package com.ias.SemilleroHandyman.infraestructure.adapters.out;

import com.ias.SemilleroHandyman.sharedDomain.models.DateRange;
import com.ias.SemilleroHandyman.application.technicalRequest.domain.TechnicalRequest;
import com.ias.SemilleroHandyman.application.technicalRequest.models.QueryByStartDate;
import com.ias.SemilleroHandyman.application.technicalRequest.models.TechnicalRequestDBO;
import com.ias.SemilleroHandyman.application.technicalRequest.models.TechnicalRequestDTO;
import com.ias.SemilleroHandyman.application.technicalRequest.ports.out.RepositoryTechnicalRequest;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.Optional;

@Repository
public class Pg_TechnicalRequestRepository implements RepositoryTechnicalRequest {

    private final DataSource dataSource;

    public Pg_TechnicalRequestRepository(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public Integer create(TechnicalRequest technicalRequest) {
        String sql = "INSERT INTO technicals_x_requests (technical_id,request_id,start_date,end_date) VALUES (?, ?, ?, ?)";
        Integer idGenerate = -1;
        try(Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setInt(1, technicalRequest.getTechnicalId().getValue());
            preparedStatement.setInt(2, technicalRequest.getRequestId().getValue());
            preparedStatement.setTimestamp(3, Timestamp.valueOf(technicalRequest.getStarDate().getValue()));
            preparedStatement.setTimestamp(4, Timestamp.valueOf(technicalRequest.getEndDate().getValue()));
            int affectedRows = preparedStatement.executeUpdate();
            if (affectedRows == 0) {
                throw new IllegalArgumentException("No se pudo guardar");
            }
            ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
            if (generatedKeys.next()) {
                idGenerate = generatedKeys.getInt(1);
            }
            return idGenerate;
        } catch (SQLException exception) {
            throw new RuntimeException("Error querying database " + exception.getMessage(),  exception);
        }
    }

    @Override
    public Optional<TechnicalRequest> getByDateRange(DateRange dateRange) {
        String sql = "Select * From technicals_x_requests Where start_date BETWEEN ? AND ? OR end_date BETWEEN ? AND ?";
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
            throw new RuntimeException("Error al consultar la base de datos ", exception);
        }
    }

    @Override
    public ArrayList<TechnicalRequestDTO> getByStartDate(QueryByStartDate queryByStartDateDTO) {
        String sql = "Select * From technicals_x_requests Where start_date BETWEEN ? AND ? AND technical_id = ?";
        try(Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setTimestamp(1,Timestamp.valueOf(queryByStartDateDTO.getStartDate()));
            preparedStatement.setTimestamp(2,Timestamp.valueOf(queryByStartDateDTO.getEndDate()));
            preparedStatement.setInt(3, Integer.parseInt(queryByStartDateDTO.getIdentification()));
            ResultSet resultSet = preparedStatement.executeQuery();
            ArrayList<TechnicalRequestDTO> technicalRequestDTOList = new ArrayList();
            while(resultSet.next()) {
                TechnicalRequestDBO technicalRequestDBO = TechnicalRequestDBO.fromResultSet(resultSet);
                TechnicalRequest technicalRequest = technicalRequestDBO.toDomain();
                technicalRequestDTOList.add(TechnicalRequestDTO.fromDomain(technicalRequest));
            }
            return technicalRequestDTOList;
        }catch (SQLException exception) {
            throw new RuntimeException("Error al consultar la base de datos ", exception);
        }
    }
}


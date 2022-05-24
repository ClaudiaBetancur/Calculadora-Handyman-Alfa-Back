package com.ias.SemilleroHandyman.technicalRequest.application.servicesDomain;

import com.ias.SemilleroHandyman.people.application.dominio.Document;
import com.ias.SemilleroHandyman.people.application.dominio.People;
import com.ias.SemilleroHandyman.people.application.ports.out.PeopleRepository;
import com.ias.SemilleroHandyman.request.application.domain.Request;
import com.ias.SemilleroHandyman.request.application.domain.RequestId;
import com.ias.SemilleroHandyman.request.application.ports.out.RequestRepository;
import com.ias.SemilleroHandyman.technicalRequest.application.domain.TechnicalRequest;
import com.ias.SemilleroHandyman.technicalRequest.application.models.QueryByStartDateDTO;
import com.ias.SemilleroHandyman.technicalRequest.application.models.TechnicalRequestDTO;
import com.ias.SemilleroHandyman.technicalRequest.application.ports.in.QueryTechnicalRequestUseCase;
import com.ias.SemilleroHandyman.technicalRequest.application.ports.out.RepositoryTechnicalRequest;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.util.ArrayList;
import java.util.Optional;

@Service
public class QueryTechnicalRequestService implements QueryTechnicalRequestUseCase {

    private final RepositoryTechnicalRequest repositoryTechnicalRequest;
    private final PeopleRepository peopleRepository;
    private final RequestRepository requestRepository;

    public QueryTechnicalRequestService(RepositoryTechnicalRequest repositoryTechnicalRequest, PeopleRepository peopleRepository, RequestRepository requestRepository) {
        this.repositoryTechnicalRequest = repositoryTechnicalRequest;
        this.peopleRepository = peopleRepository;
        this.requestRepository = requestRepository;
    }


    @Override
    public ArrayList<TechnicalRequestDTO> excute(QueryByStartDateDTO queryByStartDateDTO) {

        queryByStartDateDTO = selectTypeFilter(queryByStartDateDTO);

        Optional<TechnicalRequest> technicalRequest = repositoryTechnicalRequest.getByStartDate(queryByStartDateDTO);

        ArrayList<TechnicalRequestDTO> technicalRequestDTOList = new ArrayList();
        technicalRequest.map(technicalRequest1 -> {
            TechnicalRequestDTO technicalRequestDTO = TechnicalRequestDTO.fromDomain(technicalRequest1);
            technicalRequestDTOList.add(technicalRequestDTO);
            return true;
        });
        return technicalRequestDTOList;
    }

    private QueryByStartDateDTO selectTypeFilter(QueryByStartDateDTO queryByStartDateDTO){
        if(queryByStartDateDTO.getTypeFilter().equals("Technical")){
            queryByStartDateDTO.setTypeFilter("technical_id");
            Optional<People> people = peopleRepository.getPersonByDocument(new Document(queryByStartDateDTO.getIdentification()));
            if(people.isEmpty()){
                throw new IllegalArgumentException("El técnico no se encuentro registrado");
            }
            queryByStartDateDTO.setIdentification(people.get().getId().toString());
        }else if(queryByStartDateDTO.getTypeFilter().equals("Request")){
            queryByStartDateDTO.setTypeFilter("request_id");
            Optional<Request> request = requestRepository.get(new RequestId(Integer.parseInt(queryByStartDateDTO.getIdentification())));
            if(request.isEmpty()){
                throw new IllegalArgumentException("El servicio no se encuentra registrado");
            }
        }else{
            throw new IllegalArgumentException("Ingresa un tipo de filtro valido");
        }
        return queryByStartDateDTO;
    }
}

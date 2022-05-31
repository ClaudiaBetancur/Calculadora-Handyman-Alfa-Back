package com.ias.SemilleroHandyman.application.technicalRequest.servicesDomain;

import com.ias.SemilleroHandyman.application.people.dominio.*;
import com.ias.SemilleroHandyman.application.people.ports.out.PeopleRepository;
import com.ias.SemilleroHandyman.application.request.domain.Request;
import com.ias.SemilleroHandyman.application.request.domain.RequestId;
import com.ias.SemilleroHandyman.application.request.ports.out.RequestRepository;
import com.ias.SemilleroHandyman.application.technicalRequest.domain.TechnicalRequest;
import com.ias.SemilleroHandyman.application.technicalRequest.models.TechnicalRequestDTO;
import com.ias.SemilleroHandyman.application.technicalRequest.ports.in.CreateTechnicalRequestUseCase;
import com.ias.SemilleroHandyman.application.technicalRequest.ports.out.RepositoryTechnicalRequest;
import com.ias.SemilleroHandyman.sharedDomain.models.DateRange;
import org.apache.commons.lang3.Validate;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class CreateTechnicalRequestService implements CreateTechnicalRequestUseCase {

    private final RepositoryTechnicalRequest repositoryTechnical;
    private final PeopleRepository peopleRepository;
    private final RequestRepository requestRepository;

    public CreateTechnicalRequestService(RepositoryTechnicalRequest repositoryTechnical, PeopleRepository peopleRepository, RequestRepository requestRepository) {
        this.repositoryTechnical = repositoryTechnical;
        this.peopleRepository = peopleRepository;
        this.requestRepository = requestRepository;
    }

    @Override
    public TechnicalRequestDTO excute(TechnicalRequestDTO technicalRequestDTO) {
        validateDate(technicalRequestDTO);
        People people = checkIfRecordsExist(technicalRequestDTO);
        technicalRequestDTO.setId(0);
        technicalRequestDTO.setTechnicalId(people.getId().getValue());
        TechnicalRequest technicalRequest = technicalRequestDTO.toDomain();
        repositoryTechnical.create(technicalRequest);
        return technicalRequestDTO;
    }

    private void validateDate(TechnicalRequestDTO technicalRequestDTO){
        LocalDateTime localDateTime = LocalDateTime.now();
        Validate.isTrue(technicalRequestDTO.getStartDate().isBefore(technicalRequestDTO.getEndDate()), "La fecha de finalización no debe ser anterior a la fecha de inicio");
        Validate.isTrue(localDateTime.minusDays(7).isBefore(technicalRequestDTO.getStartDate()), "La fecha de inicio no puede ser anterior a una semana a partir de la fecha actual");
    }

    private People checkIfRecordsExist(TechnicalRequestDTO technicalRequestDTO){
        Optional<People> people = peopleRepository.getPersonByDocument(new Document(technicalRequestDTO.getDocument()));
        if(people.isEmpty()){
            throw new IllegalArgumentException("El técnico no se encuentro registrado");
        }
        Optional<Request> request = requestRepository.get(new RequestId(technicalRequestDTO.getRequestId()));
        if(request.isEmpty()){
            throw new IllegalArgumentException("El servicio no se encuentra registrado");
        }
        Optional<TechnicalRequest> technicalRequestDTO2 = repositoryTechnical.getByDateRange(new DateRange(
                technicalRequestDTO.getStartDate(),
                technicalRequestDTO.getEndDate()
        ));
        if(!technicalRequestDTO2.isEmpty()){
            throw new IllegalArgumentException("El técnico ya tiene servicios registrados en el rango de fecha ingresado");
        }
        return people.get();
    }
}

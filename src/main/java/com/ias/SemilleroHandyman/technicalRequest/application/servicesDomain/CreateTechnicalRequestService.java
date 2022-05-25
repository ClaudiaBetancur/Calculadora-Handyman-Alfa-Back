package com.ias.SemilleroHandyman.technicalRequest.application.servicesDomain;

import com.ias.SemilleroHandyman.people.application.dominio.Document;
import com.ias.SemilleroHandyman.people.application.dominio.People;
import com.ias.SemilleroHandyman.people.application.ports.out.PeopleRepository;
import com.ias.SemilleroHandyman.request.application.domain.Request;
import com.ias.SemilleroHandyman.request.application.domain.RequestId;
import com.ias.SemilleroHandyman.request.application.ports.out.RequestRepository;
import com.ias.SemilleroHandyman.sharedDomain.models.DateRange;
import com.ias.SemilleroHandyman.technicalRequest.application.domain.TechnicalRequest;
import com.ias.SemilleroHandyman.technicalRequest.application.ports.in.CreateTechnicalRequestUseCase;
import com.ias.SemilleroHandyman.technicalRequest.application.models.TechnicalRequestDTO;
import com.ias.SemilleroHandyman.technicalRequest.application.ports.out.RepositoryTechnicalRequest;
import org.apache.commons.lang3.Validate;
import org.springframework.stereotype.Service;

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

        Validate.isTrue(technicalRequestDTO.getStartDate().isBefore(technicalRequestDTO.getEndDate()), "La fecha de finalización no debe ser anterior a la fecha de inicio");

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
        technicalRequestDTO.setId(0);
        technicalRequestDTO.setTechnicalId(people.get().getId().getValue());
        TechnicalRequest technicalRequest = technicalRequestDTO.toDomain();
        repositoryTechnical.create(technicalRequest);
        return technicalRequestDTO;
    }

}

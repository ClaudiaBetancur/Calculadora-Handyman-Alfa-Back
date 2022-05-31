package com.ias.SemilleroHandyman.application.technicalRequest.servicesDomain;

import com.ias.SemilleroHandyman.application.people.ports.out.PeopleRepository;
import com.ias.SemilleroHandyman.application.request.domain.Request;
import com.ias.SemilleroHandyman.application.request.domain.RequestId;
import com.ias.SemilleroHandyman.application.request.ports.out.RequestRepository;
import com.ias.SemilleroHandyman.application.technicalRequest.models.QueryByStartDateDTO;
import com.ias.SemilleroHandyman.application.technicalRequest.models.TechinicalResquestHoursDTO;
import com.ias.SemilleroHandyman.application.technicalRequest.models.TechnicalRequestDTO;
import com.ias.SemilleroHandyman.application.technicalRequest.ports.in.QueryTechnicalRequestUseCase;
import com.ias.SemilleroHandyman.application.technicalRequest.ports.out.RepositoryTechnicalRequest;
import com.ias.SemilleroHandyman.application.people.dominio.*;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Optional;

@Service
public class QueryTechnicalRequestService implements QueryTechnicalRequestUseCase {
    private final RepositoryTechnicalRequest repositoryTechnicalRequest;
    private final PeopleRepository peopleRepository;
    private final RequestRepository requestRepository;
    private final String HOUR_NORMAL = "normal";
    private final String HOUR_NOCTURNAL = "nocturnal";
    private final String HOUR_MONDAY_TO_SATURDAY = "monday to saturday";
    private final String HOUR_SUNDAY = "SUNDAY";
    private final Integer MAX_HOUR_FOR_WEEK = 48;

    public QueryTechnicalRequestService(RepositoryTechnicalRequest repositoryTechnicalRequest, PeopleRepository peopleRepository, RequestRepository requestRepository) {
        this.repositoryTechnicalRequest = repositoryTechnicalRequest;
        this.peopleRepository = peopleRepository;
        this.requestRepository = requestRepository;
    }

    @Override
    public TechinicalResquestHoursDTO excute(QueryByStartDateDTO queryByStartDateDTO) {
        queryByStartDateDTO = selectTypeFilter(queryByStartDateDTO);
        ArrayList<TechnicalRequestDTO> technicalRequestDTOList = repositoryTechnicalRequest.getByStartDate(queryByStartDateDTO);
        return calculateHours(technicalRequestDTOList, queryByStartDateDTO);
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

    private TechinicalResquestHoursDTO calculateHours(ArrayList<TechnicalRequestDTO> technicalRequestDTOList, QueryByStartDateDTO queryByStartDateDTO){
        TechinicalResquestHoursDTO techinicalResquestHoursDTO = new TechinicalResquestHoursDTO();
        for (TechnicalRequestDTO technicalRequestDTO : technicalRequestDTOList ){
            while (technicalRequestDTO.getStartDate().isBefore(technicalRequestDTO.getEndDate())){
                if(technicalRequestDTO.getStartDate().isAfter(queryByStartDateDTO.getEndDate())){
                    break;
                }
                techinicalResquestHoursDTO = setHours(technicalRequestDTO, techinicalResquestHoursDTO);
                technicalRequestDTO.setStartDate(technicalRequestDTO.getStartDate().plusHours(1));
            }
        }
        return techinicalResquestHoursDTO;
    }

    private String getTypeDay(LocalDateTime time){
        return time.getDayOfWeek().toString().equals(HOUR_SUNDAY) ? HOUR_SUNDAY : HOUR_MONDAY_TO_SATURDAY;
    }
    private String getTypeHour(LocalDateTime time){
        String year = String.valueOf(time.getYear());
        String month = String.valueOf(time.getMonthValue());
        String day = String.valueOf(time.getDayOfMonth());
        month = month.length() == 1 ? "0" + month : month;
        day = day.length() == 1 ? "0" + day : day;
        String date = year + "-" + month + "-" + day;
        LocalDateTime startNormal = LocalDateTime.parse(date + "T07:00:00.");
        LocalDateTime endNormal = LocalDateTime.parse(date + "T19:59:59.");
        return time.isBefore(startNormal) || time.isAfter(endNormal) ? HOUR_NOCTURNAL : HOUR_NORMAL;
    }

    private TechinicalResquestHoursDTO setHours(TechnicalRequestDTO technicalRequestDTO, TechinicalResquestHoursDTO techinicalResquestHoursDTO){
        if(getTypeDay(technicalRequestDTO.getStartDate()).equals(HOUR_MONDAY_TO_SATURDAY)){
            if(getTypeHour(technicalRequestDTO.getStartDate()).equals(HOUR_NORMAL)){
                if(sumatoryOfHours(techinicalResquestHoursDTO) < MAX_HOUR_FOR_WEEK){
                    techinicalResquestHoursDTO.setNormal(techinicalResquestHoursDTO.getNormal() + 1);
                }else{
                    techinicalResquestHoursDTO.setNormalExtras(techinicalResquestHoursDTO.getNormalExtras() + 1);
                }
            }else{
                if(sumatoryOfHours(techinicalResquestHoursDTO) < MAX_HOUR_FOR_WEEK){
                    techinicalResquestHoursDTO.setNocturnal(techinicalResquestHoursDTO.getNocturnal() + 1);
                }else{
                    techinicalResquestHoursDTO.setNightExtras(techinicalResquestHoursDTO.getNightExtras() + 1);
                }
            }
        }else{
            if(sumatoryOfHours(techinicalResquestHoursDTO) < MAX_HOUR_FOR_WEEK){
                techinicalResquestHoursDTO.setSundays(techinicalResquestHoursDTO.getSundays() + 1);
            }else{
                techinicalResquestHoursDTO.setSundayExtras(techinicalResquestHoursDTO.getSundayExtras() + 1);
            }
        }
        return techinicalResquestHoursDTO;
    }

    private Integer sumatoryOfHours(TechinicalResquestHoursDTO techinicalResquestHoursDTO){
        return techinicalResquestHoursDTO.getNormal() + techinicalResquestHoursDTO.getNocturnal() + techinicalResquestHoursDTO.getSundays();
    }
}

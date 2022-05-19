package com.ias.SemilleroHandyman.technicalRequest.application.servicesDomain;

import com.ias.SemilleroHandyman.technicalRequest.application.ports.in.CreateRequestUseCase;
//import com.ias.SemilleroHandyman.people.application.ports.out.TechnicalRepository;
import com.ias.SemilleroHandyman.technicalRequest.application.models.TechnicalRequestDTO;
import org.apache.commons.lang3.Validate;

import java.time.LocalDateTime;

public class CreateRequestService implements CreateRequestUseCase {

    private final TechnicalRepository technicalRepository;

    public CreateRequestService(TechnicalRepository technicalRepository) {
        this.technicalRepository = technicalRepository;
    }

    @Override
    public TechnicalRequestDTO excute(TechnicalRequestDTO technicalRequestDTO)
    {
        LocalDateTime localDateTime = LocalDateTime.now();
        long weeks = 1;
        Validate.isTrue(technicalRequestDTO.getStartDate().isBefore(localDateTime.minusWeeks(weeks)),"the entry of records must not be greater than one week");
        Validate.isTrue(technicalRequestDTO.getEndDate().isBefore(technicalRequestDTO.getStartDate()), "the end date must not be less than the start date");

        return null;
    }

}

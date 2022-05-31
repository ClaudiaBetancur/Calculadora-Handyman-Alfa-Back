package com.ias.SemilleroHandyman.application.request.services;

import com.ias.SemilleroHandyman.application.request.ports.out.RequestRepository;
import com.ias.SemilleroHandyman.application.request.domain.Request;
import com.ias.SemilleroHandyman.application.request.models.RequestDTO;
import com.ias.SemilleroHandyman.application.request.ports.in.CreateRequestUseCase;
import org.springframework.stereotype.Service;

@Service
public class CreateRequestService implements CreateRequestUseCase {

    private final RequestRepository requestRepository;

    public CreateRequestService(RequestRepository requestRepository) {
        this.requestRepository = requestRepository;
    }

    @Override
    public RequestDTO excute(RequestDTO requestDTO) {

        Request request = requestDTO.toDomain();
        requestRepository.store(request);

        return requestDTO;
    }

}

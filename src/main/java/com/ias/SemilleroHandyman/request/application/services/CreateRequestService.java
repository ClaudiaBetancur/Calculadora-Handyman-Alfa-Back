package com.ias.SemilleroHandyman.request.application.services;

import com.ias.SemilleroHandyman.request.application.domain.Request;
import com.ias.SemilleroHandyman.request.application.models.RequestDTO;
import com.ias.SemilleroHandyman.request.application.ports.in.CreateRequestUseCase;
import com.ias.SemilleroHandyman.request.application.ports.out.RequestRepository;
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

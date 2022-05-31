package com.ias.SemilleroHandyman.application.request.services;

import com.ias.SemilleroHandyman.application.request.domain.RequestId;
import com.ias.SemilleroHandyman.application.request.ports.out.RequestRepository;
import com.ias.SemilleroHandyman.application.request.domain.Request;
import com.ias.SemilleroHandyman.application.request.models.RequestDTO;
import com.ias.SemilleroHandyman.application.request.ports.in.QueryRequestUseCase;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class QueryRequestService implements QueryRequestUseCase {

    private final RequestRepository requestRepository;

    public QueryRequestService(RequestRepository requestRepository) {
        this.requestRepository = requestRepository;
    }

    @Override
    public Optional<RequestDTO> excute(Integer id) {

        RequestId requestId = new RequestId(id);
        Optional<Request> product = requestRepository.get(requestId);
        return product.map(request1 -> {
            RequestDTO requestDTO = RequestDTO.fromDomain(request1);
            return requestDTO;
        });
    }
}

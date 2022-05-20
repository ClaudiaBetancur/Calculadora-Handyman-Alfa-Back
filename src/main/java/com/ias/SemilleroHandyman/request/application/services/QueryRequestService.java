package com.ias.SemilleroHandyman.request.application.services;

import com.ias.SemilleroHandyman.request.application.domain.Request;
import com.ias.SemilleroHandyman.request.application.domain.RequestId;
import com.ias.SemilleroHandyman.request.application.models.RequestDTO;
import com.ias.SemilleroHandyman.request.application.ports.in.QueryRequestUseCase;
import com.ias.SemilleroHandyman.request.application.ports.out.RequestRepository;
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

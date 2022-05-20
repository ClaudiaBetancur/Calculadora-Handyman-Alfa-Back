package com.ias.SemilleroHandyman.request.application.ports.out;

import com.ias.SemilleroHandyman.request.application.domain.RequestId;
import com.ias.SemilleroHandyman.request.application.domain.Request;

import java.util.Optional;

public interface RequestRepository {
    void store(Request request);
    Optional<Request> get(RequestId requestId);
}

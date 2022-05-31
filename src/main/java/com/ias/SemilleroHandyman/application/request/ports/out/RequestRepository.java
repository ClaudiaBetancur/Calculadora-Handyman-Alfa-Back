package com.ias.SemilleroHandyman.application.request.ports.out;

import com.ias.SemilleroHandyman.application.request.domain.*;
import java.util.Optional;

public interface RequestRepository {
    void store(Request request);
    Optional<Request> get(RequestId requestId);
}

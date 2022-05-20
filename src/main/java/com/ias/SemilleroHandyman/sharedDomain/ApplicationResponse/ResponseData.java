package com.ias.SemilleroHandyman.sharedDomain.ApplicationResponse;

import java.util.Objects;
import java.util.Optional;

public class ResponseData {
    private final boolean ok;
    private final String errorCode;
    private final String message;
    private final String body;

    public ResponseData(boolean ok, String errorCode, String message, String body) {
        this.ok = ok;
        this.errorCode = errorCode;
        this.message = message;
        this.body = body;
    }

    public boolean isOk() {
        return ok;
    }

    public String getBody() {
        return body;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public String getMessage() {
        return message;
    }
}

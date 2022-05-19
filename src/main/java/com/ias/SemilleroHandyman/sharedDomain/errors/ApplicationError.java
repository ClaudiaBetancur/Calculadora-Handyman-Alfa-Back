package com.ias.SemilleroHandyman.sharedDomain.errors;

public class ApplicationError {
    private final String errorCode;
    private final String message;

    public ApplicationError(String errorCode, String message) {
        this.errorCode = errorCode;
        this.message = message;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public String getMessage() {
        return message;
    }
}

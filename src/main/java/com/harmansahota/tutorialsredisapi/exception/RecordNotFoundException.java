package com.harmansahota.tutorialsredisapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class RecordNotFoundException extends RuntimeException {

    public RecordNotFoundException() {
    }

    public RecordNotFoundException(String errorMessage) {
        super(errorMessage);
    }

    public RecordNotFoundException(String errorMessage, Throwable throwable) {
        super(errorMessage, throwable);
    }
}

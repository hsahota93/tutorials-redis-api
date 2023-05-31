package com.harmansahota.tutorialsredisapi.exception;

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

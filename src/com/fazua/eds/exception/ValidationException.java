package com.fazua.eds.exception;


public class ValidationException extends RuntimeException {

    public ValidationException(String errorMessage) {
        super(errorMessage);
    }

}
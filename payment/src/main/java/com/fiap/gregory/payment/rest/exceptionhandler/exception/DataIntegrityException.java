package com.fiap.gregory.payment.rest.exceptionhandler.exception;

public class DataIntegrityException extends RuntimeException {
    public DataIntegrityException(String message) {
        super(message);
    }
}

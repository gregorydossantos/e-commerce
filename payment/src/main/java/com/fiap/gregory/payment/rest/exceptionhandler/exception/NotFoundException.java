package com.fiap.gregory.payment.rest.exceptionhandler.exception;

public class NotFoundException extends RuntimeException {
    public NotFoundException(String message) {
        super(message);
    }
}

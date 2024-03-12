package com.fiap.gregory.payment.rest.exceptionhandler.exception;

public class BadRequestException extends RuntimeException {
    public BadRequestException(String message) {
        super(message);
    }
}

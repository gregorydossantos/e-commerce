package com.fiap.gregory.itemmanager.rest.exceptionhandler.exception;

public class BadRequestException extends RuntimeException {
    public BadRequestException(String message) {
        super(message);
    }
}

package com.fiap.gregory.itemmanager.rest.exceptionhandler.exception;

public class NotFoundException extends RuntimeException {
    public NotFoundException(String message) {
        super(message);
    }
}

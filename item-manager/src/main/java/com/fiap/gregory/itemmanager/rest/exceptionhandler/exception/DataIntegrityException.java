package com.fiap.gregory.itemmanager.rest.exceptionhandler.exception;

public class DataIntegrityException extends RuntimeException {
    public DataIntegrityException(String message) {
        super(message);
    }
}

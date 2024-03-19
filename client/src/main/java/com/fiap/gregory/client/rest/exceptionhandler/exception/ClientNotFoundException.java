package com.fiap.gregory.client.rest.exceptionhandler.exception;

public class ClientNotFoundException extends RuntimeException {
    public ClientNotFoundException(String message) {
        super(message);
    }
}

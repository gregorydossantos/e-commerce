package com.fiap.gregory.itemmanager.rest.exceptionhandler.exception;

public class ItemNotFoundException extends RuntimeException {
    public ItemNotFoundException(String message) {
        super(message);
    }
}

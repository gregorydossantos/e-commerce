package com.fiap.gregory.itemmanager.rest.exceptionhandler.exception;

public class ItemBadRequestException extends RuntimeException {
    public ItemBadRequestException(String message) {
        super(message);
    }
}

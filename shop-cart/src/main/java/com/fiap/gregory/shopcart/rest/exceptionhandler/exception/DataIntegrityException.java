package com.fiap.gregory.shopcart.rest.exceptionhandler.exception;

public class DataIntegrityException extends RuntimeException {
    public DataIntegrityException(String message) {
        super(message);
    }
}

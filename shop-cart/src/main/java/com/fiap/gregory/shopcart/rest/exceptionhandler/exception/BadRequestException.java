package com.fiap.gregory.shopcart.rest.exceptionhandler.exception;

public class BadRequestException extends RuntimeException {
    public BadRequestException(String message) {
        super(message);
    }
}

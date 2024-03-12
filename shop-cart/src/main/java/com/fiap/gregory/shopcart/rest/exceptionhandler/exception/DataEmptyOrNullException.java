package com.fiap.gregory.shopcart.rest.exceptionhandler.exception;

public class DataEmptyOrNullException extends RuntimeException {
    public DataEmptyOrNullException(String message) {
        super(message);
    }
}

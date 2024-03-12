package com.fiap.gregory.payment.rest.exceptionhandler.exception;

public class DataEmptyOrNullException extends RuntimeException {
    public DataEmptyOrNullException(String message) {
        super(message);
    }
}

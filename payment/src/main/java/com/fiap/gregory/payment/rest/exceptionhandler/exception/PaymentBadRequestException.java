package com.fiap.gregory.payment.rest.exceptionhandler.exception;

public class PaymentBadRequestException extends RuntimeException {
    public PaymentBadRequestException(String message) {
        super(message);
    }
}

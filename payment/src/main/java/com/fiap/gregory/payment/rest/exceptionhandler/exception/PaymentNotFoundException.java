package com.fiap.gregory.payment.rest.exceptionhandler.exception;

public class PaymentNotFoundException extends RuntimeException {
    public PaymentNotFoundException(String message) {
        super(message);
    }
}

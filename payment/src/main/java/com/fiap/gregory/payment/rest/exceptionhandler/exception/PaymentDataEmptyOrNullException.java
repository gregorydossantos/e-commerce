package com.fiap.gregory.payment.rest.exceptionhandler.exception;

public class PaymentDataEmptyOrNullException extends RuntimeException {
    public PaymentDataEmptyOrNullException(String message) {
        super(message);
    }
}

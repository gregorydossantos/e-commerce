package com.fiap.gregory.payment.rest.exceptionhandler.exception;

public class PaymentDataIntegrityException extends RuntimeException {
    public PaymentDataIntegrityException(String message) {
        super(message);
    }
}

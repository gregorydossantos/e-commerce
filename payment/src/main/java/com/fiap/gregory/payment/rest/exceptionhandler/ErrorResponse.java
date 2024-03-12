package com.fiap.gregory.payment.rest.exceptionhandler;

import lombok.Data;

@Data
public class ErrorResponse {

    String message;

    public ErrorResponse(String message) {
        this.message = message;
    }
}

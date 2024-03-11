package com.fiap.gregory.itemmanager.rest.exceptionhandler;

import lombok.Data;

@Data
public class ErrorResponse {

    String message;

    public ErrorResponse(String message) {
        this.message = message;
    }
}

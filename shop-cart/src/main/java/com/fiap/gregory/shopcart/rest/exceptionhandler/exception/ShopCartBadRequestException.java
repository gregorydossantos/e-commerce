package com.fiap.gregory.shopcart.rest.exceptionhandler.exception;

public class ShopCartBadRequestException extends RuntimeException {
    public ShopCartBadRequestException(String message) {
        super(message);
    }
}

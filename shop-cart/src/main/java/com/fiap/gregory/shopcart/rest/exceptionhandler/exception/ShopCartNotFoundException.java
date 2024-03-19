package com.fiap.gregory.shopcart.rest.exceptionhandler.exception;

public class ShopCartNotFoundException extends RuntimeException {
    public ShopCartNotFoundException(String message) {
        super(message);
    }
}

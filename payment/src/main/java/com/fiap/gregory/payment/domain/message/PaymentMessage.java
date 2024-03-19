package com.fiap.gregory.payment.domain.message;

public class PaymentMessage {
    public static final String PATH_PAYMENT = "/v1/payment";
    public static final String SUCCESS_PAYMENT = "Payment make with success";
    public static final String FIELD_MANDATORY = "Is a mandatory field!";
    public static final String BAD_REQUEST = "Bad request!";
    public static final String DATA_EMPTY_OR_NULL = "Shopping cart is empty or null!";
    public static final String DATA_INTEGRITY = "Payment already register!";
    public static final String DATA_NOT_FOUND = "Shopping cart not found!";
}

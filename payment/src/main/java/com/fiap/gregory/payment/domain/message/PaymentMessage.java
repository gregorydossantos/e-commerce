package com.fiap.gregory.payment.domain.message;

public class PaymentMessage {
    public static final String PATH_PAYMENT = "/v1/payment";
    public static final String SUCCESS_PAYMENT = "Payment make with success";
    public static final String FIELD_MANDATORY = "Is a mandatory field!";
    public static final String INVALID_VALUE_FIELD_OPERATION = "Operation field only accept D or C character!";
    public static final String SHOP_CART_DATA_NOT_FOUND = "Shopping cart not found!";
}

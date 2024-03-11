package com.fiap.gregory.itemmanager.domain.message;

public class ItemMessage {

    public static final String PATH_ITEM = "/v1/item-manager";
    public static final String BAD_REQUEST = "Bad request!";
    public static final String DATA_EMPTY_OR_NULL = "Item is empty or null!";
    public static final String DATA_INTEGRITY = "Item already register!";
    public static final String ITEM_NOT_FOUND = "Item not found!";
    public static final String FIELD_MANDATORY = "Is a mandatory field!";
    public static final String PRODUCT_SIZE = "Product must be contain a maximum of 100 characters!";
    public static final String PRICE_SIZE = "Price must be contain precision value until 10 and scale until 2!";
}

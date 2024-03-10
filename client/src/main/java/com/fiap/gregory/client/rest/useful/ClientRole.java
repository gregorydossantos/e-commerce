package com.fiap.gregory.client.rest.useful;

public enum ClientRole {
    A ("A"), U("U");
    private String value;
    ClientRole(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}

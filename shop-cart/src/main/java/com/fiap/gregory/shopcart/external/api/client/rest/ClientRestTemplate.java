package com.fiap.gregory.shopcart.external.api.client.rest;

import com.fiap.gregory.shopcart.external.api.client.response.ClientResponse;

public interface ClientRestTemplate {

    ClientResponse getClientById(Long id);
}

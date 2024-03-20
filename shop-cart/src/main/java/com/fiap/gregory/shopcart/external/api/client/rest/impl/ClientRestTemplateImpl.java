package com.fiap.gregory.shopcart.external.api.client.rest.impl;

import com.fiap.gregory.shopcart.external.api.client.response.ClientResponse;
import com.fiap.gregory.shopcart.external.api.client.rest.ClientRestTemplate;
import org.springframework.web.client.RestTemplate;

public class ClientRestTemplateImpl implements ClientRestTemplate {

    private static final String PATH_API_SHOPPING_CART = "http://localhost:8081/v1/shop-cart/";

    @Override
    public ClientResponse getClientById(Long id) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(PATH_API_SHOPPING_CART + id, ClientResponse.class);
    }
}

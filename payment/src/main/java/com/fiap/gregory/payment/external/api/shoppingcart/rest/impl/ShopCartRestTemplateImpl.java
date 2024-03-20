package com.fiap.gregory.payment.external.api.shoppingcart.rest.impl;

import com.fiap.gregory.payment.external.api.shoppingcart.response.ShopCartResponse;
import com.fiap.gregory.payment.external.api.shoppingcart.rest.ShopCartRestTemplate;
import org.springframework.web.client.RestTemplate;

public class ShopCartRestTemplateImpl implements ShopCartRestTemplate {

    private static final String PATH_API_SHOPPING_CART = "http://localhost:8083/v1/shop-cart/";

    @Override
    public ShopCartResponse getShoppingCartById(Long id) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(PATH_API_SHOPPING_CART + id, ShopCartResponse.class);
    }
}

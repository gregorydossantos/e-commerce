package com.fiap.gregory.payment.external.api.shoppingcart.rest;

import com.fiap.gregory.payment.external.api.shoppingcart.response.ShopCartResponse;

public interface ShopCartRestTemplate {

    ShopCartResponse getShoppingCartById(Long id);
}

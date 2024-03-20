package com.fiap.gregory.shopcart.service.query;

import com.fiap.gregory.shopcart.rest.dto.response.ShopCartResponse;

public interface ShopCartServiceQuery {

    ShopCartResponse getShopCartById(Long id);
}

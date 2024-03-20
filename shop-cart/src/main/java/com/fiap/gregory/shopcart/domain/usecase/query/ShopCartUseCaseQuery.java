package com.fiap.gregory.shopcart.domain.usecase.query;

import com.fiap.gregory.shopcart.rest.dto.response.ShopCartResponse;

public interface ShopCartUseCaseQuery {

    ShopCartResponse getShopCartById(Long id);
}

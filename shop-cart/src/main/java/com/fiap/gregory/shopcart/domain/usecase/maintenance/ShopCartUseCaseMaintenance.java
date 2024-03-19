package com.fiap.gregory.shopcart.domain.usecase.maintenance;

import com.fiap.gregory.shopcart.rest.dto.request.ShopCartRequest;
import com.fiap.gregory.shopcart.rest.dto.response.ShopCartResponse;

public interface ShopCartUseCaseMaintenance {
    void createShopCart(ShopCartRequest request);

    ShopCartResponse increaseProduct(Long id, ShopCartRequest request);

    void deleteProduct(Long id, String idShopCart, Long itemId);
}

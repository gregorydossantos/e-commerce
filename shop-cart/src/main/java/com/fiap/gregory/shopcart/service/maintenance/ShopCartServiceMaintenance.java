package com.fiap.gregory.shopcart.service.maintenance;

import com.fiap.gregory.shopcart.rest.dto.request.ShopCartRequest;
import com.fiap.gregory.shopcart.rest.dto.response.ShopCartResponse;

public interface ShopCartServiceMaintenance {

    void createShopCart(ShopCartRequest request);

    ShopCartResponse increaseProduct(Long id, ShopCartRequest request);

    void deleteProduct(Long id);
}

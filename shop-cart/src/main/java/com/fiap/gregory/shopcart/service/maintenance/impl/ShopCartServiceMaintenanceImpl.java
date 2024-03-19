package com.fiap.gregory.shopcart.service.maintenance.impl;

import com.fiap.gregory.shopcart.domain.usecase.maintenance.ShopCartUseCaseMaintenance;
import com.fiap.gregory.shopcart.rest.dto.request.ShopCartRequest;
import com.fiap.gregory.shopcart.rest.dto.response.ShopCartResponse;
import com.fiap.gregory.shopcart.service.maintenance.ShopCartServiceMaintenance;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class ShopCartServiceMaintenanceImpl implements ShopCartServiceMaintenance {

    ShopCartUseCaseMaintenance useCaseMaintenance;

    @Override
    public void createShopCart(ShopCartRequest request) {
        useCaseMaintenance.createShopCart(request);
    }

    @Override
    public ShopCartResponse increaseProduct(Long id, ShopCartRequest request) {
        return useCaseMaintenance.increaseProduct(id, request);
    }

    @Override
    public void deleteProduct(Long id, String idShopCart, Long itemId) {
        useCaseMaintenance.deleteProduct(id, idShopCart, itemId);
    }
}

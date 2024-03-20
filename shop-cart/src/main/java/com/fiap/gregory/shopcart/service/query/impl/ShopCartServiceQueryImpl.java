package com.fiap.gregory.shopcart.service.query.impl;

import com.fiap.gregory.shopcart.domain.usecase.query.ShopCartUseCaseQuery;
import com.fiap.gregory.shopcart.rest.dto.response.ShopCartResponse;
import com.fiap.gregory.shopcart.service.query.ShopCartServiceQuery;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class ShopCartServiceQueryImpl implements ShopCartServiceQuery {

    ShopCartUseCaseQuery shopCartUseCaseQuery;

    @Override
    public ShopCartResponse getShopCartById(Long id) {
        return shopCartUseCaseQuery.getShopCartById(id);
    }
}

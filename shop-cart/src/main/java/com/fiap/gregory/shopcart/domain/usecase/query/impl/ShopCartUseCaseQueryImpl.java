package com.fiap.gregory.shopcart.domain.usecase.query.impl;

import com.fiap.gregory.shopcart.domain.mapper.ShopCartMapper;
import com.fiap.gregory.shopcart.domain.usecase.query.ShopCartUseCaseQuery;
import com.fiap.gregory.shopcart.infra.db.repository.ShopCartRepository;
import com.fiap.gregory.shopcart.rest.dto.response.ShopCartResponse;
import com.fiap.gregory.shopcart.rest.exceptionhandler.exception.ShopCartNotFoundException;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import static com.fiap.gregory.shopcart.domain.message.ShopCartMessage.SHOP_CART_NOT_FOUND;

@Service
@AllArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class ShopCartUseCaseQueryImpl implements ShopCartUseCaseQuery {

    ShopCartRepository shopCartRepository;
    ShopCartMapper shopCartMapper;

    @Override
    public ShopCartResponse getShopCartById(Long id) {
        var response = shopCartRepository.findById(id);

        if (response.isEmpty()) {
            throw new ShopCartNotFoundException(SHOP_CART_NOT_FOUND);
        }

        return shopCartMapper.toResponse(response.get());
    }
}

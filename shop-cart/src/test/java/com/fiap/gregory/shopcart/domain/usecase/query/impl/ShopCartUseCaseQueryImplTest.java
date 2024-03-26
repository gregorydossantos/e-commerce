package com.fiap.gregory.shopcart.domain.usecase.query.impl;

import com.fiap.gregory.shopcart.domain.mapper.ShopCartMapper;
import com.fiap.gregory.shopcart.infra.db.model.ShopCart;
import com.fiap.gregory.shopcart.infra.db.repository.ShopCartRepository;
import com.fiap.gregory.shopcart.rest.dto.response.ShopCartResponse;
import com.fiap.gregory.shopcart.rest.exceptionhandler.exception.ShopCartNotFoundException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@SpringBootTest
@ActiveProfiles("test")
class ShopCartUseCaseQueryImplTest {

    @Mock
    ShopCartRepository repository;

    @Mock
    ShopCartMapper mapper;

    @InjectMocks
    ShopCartUseCaseQueryImpl useCaseQuery;

    @Test
    @DisplayName("USE CASE LAYER ::: Get a shopping cart successfully")
    void getShopCartById() {
        var shopCart = Mockito.mock(ShopCart.class);
        var shopCartResponse = Mockito.mock(ShopCartResponse.class);
        when(repository.findById(1L)).thenReturn(Optional.ofNullable(shopCart));
        when(mapper.toResponse(shopCart)).thenReturn(shopCartResponse);

        var response = useCaseQuery.getShopCartById(1L);
        assertNotNull(response);
    }

    @Test
    @DisplayName("USE CASE LAYER ::: throws ShopCartNotFoundException")
    void throwsShopCartNotFoundException() {
        when(repository.findById(1L)).thenReturn(Optional.empty());
        assertThrows(ShopCartNotFoundException.class, () -> useCaseQuery.getShopCartById(1L));
    }
}
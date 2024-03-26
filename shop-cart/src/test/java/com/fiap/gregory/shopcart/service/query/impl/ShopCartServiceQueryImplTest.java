package com.fiap.gregory.shopcart.service.query.impl;

import com.fiap.gregory.shopcart.domain.usecase.query.ShopCartUseCaseQuery;
import com.fiap.gregory.shopcart.rest.dto.response.ShopCartResponse;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
@ActiveProfiles("test")
class ShopCartServiceQueryImplTest {

    @Mock
    ShopCartUseCaseQuery useCaseQuery;

    @InjectMocks
    ShopCartServiceQueryImpl serviceQuery;

    @Test
    @DisplayName("SERVICE LAYER ::: Get a Shopping Cart by ID")
    void getShopCartById() {
        var shopCartResponse = Mockito.mock(ShopCartResponse.class);
        when(useCaseQuery.getShopCartById(1L)).thenReturn(shopCartResponse);

        var response = serviceQuery.getShopCartById(1L);
        assertNotNull(response);
    }
}
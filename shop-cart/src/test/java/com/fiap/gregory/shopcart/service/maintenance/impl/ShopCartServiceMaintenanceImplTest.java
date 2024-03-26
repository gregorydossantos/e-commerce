package com.fiap.gregory.shopcart.service.maintenance.impl;

import com.fiap.gregory.shopcart.domain.usecase.maintenance.ShopCartUseCaseMaintenance;
import com.fiap.gregory.shopcart.rest.dto.request.ShopCartRequest;
import com.fiap.gregory.shopcart.rest.dto.response.ShopCartResponse;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
@ActiveProfiles("test")
class ShopCartServiceMaintenanceImplTest {

    @Mock
    ShopCartUseCaseMaintenance useCaseMaintenance;

    @InjectMocks
    ShopCartServiceMaintenanceImpl serviceMaintenance;

    @Test
    @DisplayName("SERVICE LAYER ::: Create Shopping Cart")
    void createShopCart() {
        var request = Mockito.mock(ShopCartRequest.class);
        doNothing().when(useCaseMaintenance).createShopCart(request);

        serviceMaintenance.createShopCart(request);
        verify(useCaseMaintenance).createShopCart(request);
    }

    @Test
    @DisplayName("SERVICE LAYER ::: Update Shopping Cart")
    void increaseProduct() {
        var request = Mockito.mock(ShopCartRequest.class);
        var shopCartResponse = Mockito.mock(ShopCartResponse.class);
        when(useCaseMaintenance.increaseProduct(1L, request)).thenReturn(shopCartResponse);

        var response = serviceMaintenance.increaseProduct(1L, request);
        assertNotNull(response);
    }

    @Test
    @DisplayName("SERVICE LAYER ::: Delete Shopping Cart")
    void deleteProduct() {
        doNothing().when(useCaseMaintenance).deleteProduct(1L);

        serviceMaintenance.deleteProduct(1L);
        verify(useCaseMaintenance).deleteProduct(1L);
    }
}
package com.fiap.gregory.shopcart.domain.usecase.maintenance.impl;

import com.fiap.gregory.shopcart.domain.mapper.ShopCartMapper;
import com.fiap.gregory.shopcart.external.api.client.response.ClientResponse;
import com.fiap.gregory.shopcart.external.api.client.rest.ClientRestTemplate;
import com.fiap.gregory.shopcart.external.api.item.response.ItemResponse;
import com.fiap.gregory.shopcart.external.api.item.rest.ItemRestTemplate;
import com.fiap.gregory.shopcart.infra.db.model.ShopCart;
import com.fiap.gregory.shopcart.infra.db.repository.ShopCartRepository;
import com.fiap.gregory.shopcart.rest.dto.request.ShopCartRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
@ActiveProfiles("test")
class ShopCartUseCaseMaintenanceImplTest {

    @Mock
    ShopCartRepository shopCartRepository;

    @Mock
    ShopCartMapper shopCartMapper;

    @Mock
    ClientRestTemplate clientRestTemplate;

    @Mock
    ItemRestTemplate itemRestTemplate;

    @InjectMocks
    ShopCartUseCaseMaintenanceImpl useCaseMaintenance;

    ShopCartRequest request;
    ShopCart shopCart;
    ClientResponse clientResponse;
    ItemResponse itemResponse;

    @BeforeEach
    void setUp() {
        request = Mockito.mock(ShopCartRequest.class);
        shopCart = Mockito.mock(ShopCart.class);
        clientResponse = Mockito.mock(ClientResponse.class);
        itemResponse = Mockito.mock(ItemResponse.class);
    }

    @Test
    @DisplayName("USE CASE LAYER ::: Create shopping cart successfully")
    void createShopCart() {
        when(clientRestTemplate.getClientById("1")).thenReturn(clientResponse);
        when(itemRestTemplate.getItemById("1")).thenReturn(itemResponse);

        useCaseMaintenance.createShopCart(request);
    }

    @Test
    @DisplayName("USE CASE LAYER ::: Update shopping cart successfully")
    void increaseProduct() {
        when(shopCartRepository.existsById(1L)).thenReturn(Boolean.TRUE);
        when(clientRestTemplate.getClientById("1")).thenReturn(clientResponse);
        when(itemRestTemplate.getItemById("1")).thenReturn(itemResponse);
        when(shopCartRepository.findById(1L)).thenReturn(Optional.ofNullable(shopCart));

        useCaseMaintenance.increaseProduct(1L, request);
    }

    @Test
    @DisplayName("USE CASE LAYER ::: Delete shopping cart successfully")
    void deleteProduct() {
        when(shopCartRepository.existsById(1L)).thenReturn(Boolean.TRUE);
        useCaseMaintenance.deleteProduct(1L);
    }
}
package com.fiap.gregory.shopcart.domain.mapper;

import com.fiap.gregory.shopcart.infra.db.model.ShopCart;
import com.fiap.gregory.shopcart.rest.dto.request.ShopCartRequest;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
class ShopCartMapperTest {

    @Autowired
    ShopCartMapper mapper;

    @Test
    void toEntity() {
        var request = Mockito.mock(ShopCartRequest.class);
        var response = mapper.toEntity(request);
        assertNotNull(response);
    }

    @Test
    void toUpdateEntity() {
        var request = Mockito.mock(ShopCartRequest.class);
        var shopCart = Mockito.mock(ShopCart.class);
        var response = mapper.toUpdateEntity(request, shopCart);
        assertNotNull(response);
    }

    @Test
    void toResponse() {
        var shopCart = Mockito.mock(ShopCart.class);
        var response = mapper.toResponse(shopCart);
        assertNotNull(response);
    }
}
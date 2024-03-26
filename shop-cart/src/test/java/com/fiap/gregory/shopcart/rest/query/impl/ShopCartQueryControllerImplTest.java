package com.fiap.gregory.shopcart.rest.query.impl;

import com.fiap.gregory.shopcart.rest.dto.response.ShopCartResponse;
import com.fiap.gregory.shopcart.service.query.ShopCartServiceQuery;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.ActiveProfiles;

import static com.fiap.gregory.shopcart.domain.message.ShopCartMessage.PATH_SHOP_CART;
import static io.restassured.RestAssured.given;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ActiveProfiles("test")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ShopCartQueryControllerImplTest {

    private static final String PATH_SHOP_CART_ID = PATH_SHOP_CART + "/1";

    @LocalServerPort
    int port;

    @MockBean
    ShopCartServiceQuery serviceQuery;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        RestAssured.port = port;
    }

    @Test
    @DisplayName("REST LAYER - Get a shopping cart by id ::: Should be return a http status 200 - OK")
    void getShopCartById() {
        var shopCartResponse = Mockito.mock(ShopCartResponse.class);
        when(serviceQuery.getShopCartById(1L)).thenReturn(shopCartResponse);

        given()
                .contentType(ContentType.JSON)
                .when().get(PATH_SHOP_CART_ID)
                .then().statusCode(HttpStatus.OK.value());

        verify(serviceQuery).getShopCartById(1L);
    }
}
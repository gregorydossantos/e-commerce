package com.fiap.gregory.shopcart.rest.maintenance.impl;

import com.fiap.gregory.shopcart.rest.dto.request.ShopCartRequest;
import com.fiap.gregory.shopcart.rest.dto.response.ShopCartResponse;
import com.fiap.gregory.shopcart.service.maintenance.ShopCartServiceMaintenance;
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
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

@ActiveProfiles("test")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ShopCartMaintenanceControllerImplTest {

    private static final String PATH_SHOP_CART_ID = PATH_SHOP_CART + "/1";

    @LocalServerPort
    int port;

    @MockBean
    ShopCartServiceMaintenance serviceMaintenance;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        RestAssured.port = port;
    }

    @Test
    @DisplayName("REST LAYER - Create Shopping Cart ::: Should be return a http status 201 - CREATED")
    void createShopCart() {
        var request = Mockito.mock(ShopCartRequest.class);
        doNothing().when(serviceMaintenance).createShopCart(any(ShopCartRequest.class));

        given()
                .contentType(ContentType.JSON)
                .body(request)
                .when().post(PATH_SHOP_CART)
                .then().statusCode(HttpStatus.CREATED.value());

        verify(serviceMaintenance).createShopCart(any(ShopCartRequest.class));
    }

    @Test
    @DisplayName("REST LAYER - Update Shopping Cart ::: Should be return a http status 200 - OK")
    void increaseProduct() {
        var request = Mockito.mock(ShopCartRequest.class);
        var response = Mockito.mock(ShopCartResponse.class);
        when(serviceMaintenance.increaseProduct(1L, request)).thenReturn(response);

        given()
                .contentType(ContentType.JSON)
                .body(request)
                .when().put(PATH_SHOP_CART_ID)
                .then().statusCode(HttpStatus.OK.value());

        verify(serviceMaintenance).increaseProduct(anyLong(), any(ShopCartRequest.class));
    }

    @Test
    @DisplayName("REST LAYER - Delete Update Shopping Cart ::: Should be return a http status 200 - OK")
    void deleteProduct() {
        doNothing().when(serviceMaintenance).deleteProduct(anyLong());

        given()
                .contentType(ContentType.JSON)
                .when().delete(PATH_SHOP_CART_ID)
                .then().statusCode(HttpStatus.OK.value());

        verify(serviceMaintenance).deleteProduct(anyLong());
    }
}
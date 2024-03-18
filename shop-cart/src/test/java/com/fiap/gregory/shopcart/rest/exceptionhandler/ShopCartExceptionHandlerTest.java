package com.fiap.gregory.shopcart.rest.exceptionhandler;

import com.fiap.gregory.shopcart.rest.exceptionhandler.exception.ShopCartBadRequestException;
import com.fiap.gregory.shopcart.rest.exceptionhandler.exception.ShopCartDataEmptyOrNullException;
import com.fiap.gregory.shopcart.rest.exceptionhandler.exception.ShopCartDataIntegrityException;
import com.fiap.gregory.shopcart.rest.exceptionhandler.exception.ShopCartNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;

import static com.fiap.gregory.shopcart.domain.message.ShopCartMessage.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@ActiveProfiles("test")
class ShopCartExceptionHandlerTest {

    @InjectMocks
    ShopCartExceptionHandler shopCartExceptionHandler;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName("Should be returns BadRequestException")
    void should_ReturnsBadRequestException_When_RequestIsInvalid() {
        ResponseEntity<ErrorResponse> response = shopCartExceptionHandler.badRequestException(
                new ShopCartBadRequestException(BAD_REQUEST));

        assertNotNull(response);
        assertEquals(response.getStatusCode(), HttpStatus.BAD_REQUEST);
    }

    @Test
    @DisplayName("Should be returns DataEmptyOrNullException")
    void should_ReturnsDataEmptyOrNullException_When_ShoppingCartIsEmpty() {
        ResponseEntity<ErrorResponse> response = shopCartExceptionHandler.dataEmptyOrNullException(
                new ShopCartDataEmptyOrNullException(DATA_EMPTY_OR_NULL));

        assertNotNull(response);
        assertEquals(response.getStatusCode(), HttpStatus.BAD_REQUEST);
    }

    @Test
    @DisplayName("Should be returns DataIntegrityException")
    void should_ReturnsDataIntegrityException_When_ShoppingCartAlreadyExists() {
        ResponseEntity<ErrorResponse> response = shopCartExceptionHandler.dataIntegrityException(
                new ShopCartDataIntegrityException(DATA_INTEGRITY));

        assertNotNull(response);
        assertEquals(response.getStatusCode(), HttpStatus.BAD_REQUEST);
    }

    @Test
    @DisplayName("Should be returns NotFoundException")
    void should_ReturnsNotFoundException_When_ShoppingCartNotFound() {
        ResponseEntity<ErrorResponse> response = shopCartExceptionHandler.notFoundException(
                new ShopCartNotFoundException(SHOP_CART_NOT_FOUND));

        assertNotNull(response);
        assertEquals(response.getStatusCode(), HttpStatus.NOT_FOUND);
    }
}
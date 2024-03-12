package com.fiap.gregory.itemmanager.rest.exceptionhandler;

import com.fiap.gregory.itemmanager.rest.exceptionhandler.exception.BadRequestException;
import com.fiap.gregory.itemmanager.rest.exceptionhandler.exception.DataEmptyOrNullException;
import com.fiap.gregory.itemmanager.rest.exceptionhandler.exception.DataIntegrityException;
import com.fiap.gregory.itemmanager.rest.exceptionhandler.exception.NotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;

import static com.fiap.gregory.itemmanager.domain.message.ItemMessage.BAD_REQUEST;
import static com.fiap.gregory.itemmanager.domain.message.ItemMessage.DATA_INTEGRITY;
import static com.fiap.gregory.itemmanager.domain.message.ItemMessage.ITEM_NOT_FOUND;
import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@ActiveProfiles("test")
class ItemExceptionHandlerTest {

    @InjectMocks
    ItemExceptionHandler itemExceptionHandler;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName("Should be return BadRequestException")
    void should_ReturnsBadRequestException_When_ClientRequestHasError() {
        ResponseEntity<ErrorResponse> response = itemExceptionHandler.badRequestException(
                new BadRequestException(BAD_REQUEST));

        assertNotNull(response);
        assertEquals(response.getStatusCode(), HttpStatus.BAD_REQUEST);
    }

    @Test
    @DisplayName("Should be return DataEmptyOrNullException")
    void should_ReturnsDataEmptyOrNullException_When_ClientIsEmptyOrNull() {
        ResponseEntity<ErrorResponse> response = itemExceptionHandler.dataEmptyOrNullException(
                new DataEmptyOrNullException(ITEM_NOT_FOUND));

        assertNotNull(response);
        assertEquals(response.getStatusCode(), HttpStatus.NOT_FOUND);
    }

    @Test
    @DisplayName("Should be return DataIntegrityException")
    void should_ReturnsDataIntegrityException_When_ClientAlreadyExists() {
        ResponseEntity<ErrorResponse> response = itemExceptionHandler.dataIntegrityException(
                new DataIntegrityException(DATA_INTEGRITY));

        assertNotNull(response);
        assertEquals(response.getStatusCode(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Test
    @DisplayName("Should be return NotFoundException")
    void should_ReturnsNotFoundException_When_ClientNotFound() {
        ResponseEntity<ErrorResponse> response = itemExceptionHandler.notFoundException(
                new NotFoundException(ITEM_NOT_FOUND));

        assertNotNull(response);
        assertEquals(response.getStatusCode(), HttpStatus.NOT_FOUND);
    }

}
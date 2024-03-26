package com.fiap.gregory.payment.rest.exceptionhandler;

import com.fiap.gregory.payment.rest.exceptionhandler.exception.PaymentBadRequestException;
import com.fiap.gregory.payment.rest.exceptionhandler.exception.PaymentDataEmptyOrNullException;
import com.fiap.gregory.payment.rest.exceptionhandler.exception.PaymentDataIntegrityException;
import com.fiap.gregory.payment.rest.exceptionhandler.exception.PaymentNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;

import static com.fiap.gregory.payment.domain.message.PaymentMessage.*;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ActiveProfiles("test")
class PaymentExceptionHandlerTest {

    @InjectMocks
    PaymentExceptionHandler exceptionHandler;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName("Should be return BadRequestException")
    void badRequestException() {
        ResponseEntity<ErrorResponse> error = exceptionHandler.badRequestException(
                new PaymentBadRequestException(BAD_REQUEST));

        assertNotNull(error);
        assertEquals(error.getStatusCode(), HttpStatus.BAD_REQUEST);
    }

    @Test
    @DisplayName("Should be return DataEmptyOrNullException")
    void dataEmptyOrNullException() {
        ResponseEntity<ErrorResponse> error = exceptionHandler.dataEmptyOrNullException(
                new PaymentDataEmptyOrNullException(DATA_EMPTY_OR_NULL));

        assertNotNull(error);
        assertEquals(error.getStatusCode(), HttpStatus.NOT_FOUND);
    }

    @Test
    @DisplayName("Should be return DataIntegrityException")
    void dataIntegrityException() {
        ResponseEntity<ErrorResponse> error = exceptionHandler.dataIntegrityException(
                new PaymentDataIntegrityException(DATA_INTEGRITY));

        assertNotNull(error);
        assertEquals(error.getStatusCode(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Test
    @DisplayName("Should be return NotFoundException")
    void notFoundException() {
        ResponseEntity<ErrorResponse> error = exceptionHandler.notFoundException(
                new PaymentNotFoundException(NOT_FOUND));

        assertNotNull(error);
        assertEquals(error.getStatusCode(), HttpStatus.NOT_FOUND);
    }
}
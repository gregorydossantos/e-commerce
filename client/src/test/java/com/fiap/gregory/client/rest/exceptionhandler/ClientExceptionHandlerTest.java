package com.fiap.gregory.client.rest.exceptionhandler;

import com.fiap.gregory.client.rest.exceptionhandler.exception.ClientDataIntegrityException;
import com.fiap.gregory.client.rest.exceptionhandler.exception.ClientNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;

import static com.fiap.gregory.client.domain.message.ClientMessage.CLIENT_NOT_FOUND;
import static com.fiap.gregory.client.domain.message.ClientMessage.DATA_INTEGRITY;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@ActiveProfiles("test")
class ClientExceptionHandlerTest {

    @InjectMocks
    ClientExceptionHandler clientExceptionHandler;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName("Should be return DataIntegrityException")
    void should_ReturnsDataIntegrityException_When_ClientAlreadyExists() {
        ResponseEntity<ErrorResponse> response = clientExceptionHandler.dataIntegrityException(
                new ClientDataIntegrityException(DATA_INTEGRITY));

        assertNotNull(response);
        assertEquals(response.getStatusCode(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Test
    @DisplayName("Should be return NotFoundException")
    void should_ReturnsNotFoundException_When_ClientNonExists() {
        ResponseEntity<ErrorResponse> response = clientExceptionHandler.notFoundException(
                new ClientNotFoundException(CLIENT_NOT_FOUND));

        assertNotNull(response);
        assertEquals(response.getStatusCode(), HttpStatus.NOT_FOUND);
    }
}
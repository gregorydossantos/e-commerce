package com.fiap.gregory.client.domain.usecase.query.impl;

import com.fiap.gregory.client.domain.mapper.ClientMapper;
import com.fiap.gregory.client.infra.db.model.Client;
import com.fiap.gregory.client.infra.db.repository.ClientRepository;
import com.fiap.gregory.client.rest.dto.response.ClientResponse;
import com.fiap.gregory.client.rest.exceptionhandler.exception.ClientNotFoundException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.Optional;

import static com.fiap.gregory.client.domain.message.ClientMessage.CLIENT_NOT_FOUND;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

@SpringBootTest
@ActiveProfiles("test")
class ClientQueryUseCaseImplTest {

    @Mock
    ClientRepository repository;

    @Mock
    ClientMapper mapper;

    @InjectMocks
    ClientQueryUseCaseImpl useCase;

    @Test
    @DisplayName("USE CASE LAYER ::: Get a client successfully")
    void getClientById() {
        var client = Mockito.mock(Client.class);
        var clientResponse = Mockito.mock(ClientResponse.class);

        when(repository.existsById(anyLong())).thenReturn(Boolean.TRUE);
        when(repository.findById(anyLong())).thenReturn(Optional.of(client));
        when(mapper.toResponse(client)).thenReturn(clientResponse);

        var response = useCase.getClientById(1L);
        assertNotNull(response);
    }

    @Test
    @DisplayName("USE CASE LAYER ::: Get a client with error")
    void clientNotFoundException() {
        when(repository.existsById(anyLong())).thenReturn(Boolean.FALSE);
        assertThrows(ClientNotFoundException.class, () -> useCase.getClientById(anyLong()));
    }
}
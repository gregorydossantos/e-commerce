package com.fiap.gregory.client.service.query.impl;

import com.fiap.gregory.client.domain.usecase.query.ClientQueryUseCase;
import com.fiap.gregory.client.rest.dto.response.ClientResponse;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

@SpringBootTest
@ActiveProfiles("test")
class ClientQueryServiceImplTest {

    @Mock
    ClientQueryUseCase clientQueryUseCase;

    @InjectMocks
    ClientQueryServiceImpl clientQueryService;

    @Test
    @DisplayName("SERVICE LAYER ::: Get a client successfully")
    void getClientById() {
        when(clientQueryUseCase.getClientById(anyLong())).thenReturn(Mockito.mock(ClientResponse.class));
        var response = clientQueryService.getClientById(1L);
        assertNotNull(response);
    }
}
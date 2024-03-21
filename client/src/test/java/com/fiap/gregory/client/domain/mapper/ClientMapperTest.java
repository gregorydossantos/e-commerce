package com.fiap.gregory.client.domain.mapper;

import com.fiap.gregory.client.infra.db.model.Client;
import com.fiap.gregory.client.rest.dto.request.ClientRequest;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
class ClientMapperTest {

    @Autowired
    ClientMapper mapper;

    @Test
    void should_ReturnsClient_When_CallToEntityMethod() {
        var mockClientRequest = Mockito.mock(ClientRequest.class);
        var client = mapper.toEntity(mockClientRequest);
        assertNotNull(client);
    }

    @Test
    void should_ReturnsClientResponse_When_CallToResponseMethod() {
        var mockClient = Mockito.mock(Client.class);
        var clientResponse = mapper.toResponse(mockClient);
        assertNotNull(clientResponse);
    }
}
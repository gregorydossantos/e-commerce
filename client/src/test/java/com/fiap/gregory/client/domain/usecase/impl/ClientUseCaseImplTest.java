package com.fiap.gregory.client.domain.usecase.impl;

import com.fiap.gregory.client.domain.mapper.ClientMapper;
import com.fiap.gregory.client.infra.db.model.Client;
import com.fiap.gregory.client.infra.db.repository.ClientRepository;
import com.fiap.gregory.client.rest.dto.request.ClientRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
@ActiveProfiles("test")
class ClientUseCaseImplTest {

    ClientRequest request;

    @Mock
    ClientMapper mapper;

    @Mock
    ClientRepository repository;

    @InjectMocks
    ClientUseCaseImpl useCase;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        mockRequest();
    }

    private void mockRequest() {
        request = ClientRequest.builder()
                .name("Gregory")
                .lastName("Test")
                .email("gregory.test@email.com")
                .password(1234567890)
                .build();
    }

    @Test
    @DisplayName("USE CASE LAYER ::: Create client successfully")
    void should_ReturnsHttpStatusCreated_When_CreateClientWithSuccess() {
        var client = Mockito.mock(Client.class);

        when(repository.findByEmail(anyString())).thenReturn(Optional.empty());
        when(mapper.toEntity(request)).thenReturn(client);

        useCase.createClient(request);

        verify(repository).save(any(Client.class));
    }
}
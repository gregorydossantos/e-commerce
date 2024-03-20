package com.fiap.gregory.client.service.maintenance.impl;

import com.fiap.gregory.client.domain.usecase.maintenance.ClientMaintenanceUseCase;
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

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;

@SpringBootTest
@ActiveProfiles("test")
class ClientMaintenanceServiceImplTest {

    @Mock
    ClientMaintenanceUseCase useCase;

    @Mock
    ClientRepository clientRepository;

    @InjectMocks
    ClientMaintenanceServiceImpl clientService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName("SERVICE LAYER ::: Create client successfully")
    void should_ReturnsHttpStatusCreated_When_CreateClientWithSuccess() {
        var request = Mockito.mock(ClientRequest.class);
        var client = Mockito.mock(Client.class);
        doNothing().when(useCase).createClient(any(ClientRequest.class));

        clientService.createClient(request);

        verify(clientRepository).save(client);
    }
}
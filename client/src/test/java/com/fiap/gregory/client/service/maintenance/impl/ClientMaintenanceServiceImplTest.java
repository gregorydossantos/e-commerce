package com.fiap.gregory.client.service.maintenance.impl;

import com.fiap.gregory.client.domain.mapper.ClientMapper;
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
import static org.mockito.Mockito.*;

@SpringBootTest
@ActiveProfiles("test")
class ClientMaintenanceServiceImplTest {

    @Mock
    ClientMaintenanceUseCase useCase;

    @InjectMocks
    ClientMaintenanceServiceImpl service;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName("SERVICE LAYER ::: Create client successfully")
    void should_ReturnsHttpStatusCreated_When_CreateClientWithSuccess() {
        var request = Mockito.mock(ClientRequest.class);
        doNothing().when(useCase).createClient(request);
        service.createClient(request);
    }
}
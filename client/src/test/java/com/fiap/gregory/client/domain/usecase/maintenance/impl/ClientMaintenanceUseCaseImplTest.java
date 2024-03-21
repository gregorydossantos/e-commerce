package com.fiap.gregory.client.domain.usecase.maintenance.impl;

import com.fiap.gregory.client.domain.mapper.ClientMapper;
import com.fiap.gregory.client.domain.usecase.maintenance.impl.ClientMaintenanceUseCaseImpl;
import com.fiap.gregory.client.infra.db.model.Client;
import com.fiap.gregory.client.infra.db.repository.ClientRepository;
import com.fiap.gregory.client.rest.dto.request.ClientRequest;
import com.fiap.gregory.client.rest.exceptionhandler.exception.ClientDataIntegrityException;
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

import static com.fiap.gregory.client.rest.useful.ClientRole.U;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
@ActiveProfiles("test")
class ClientMaintenanceUseCaseImplTest {

    @Mock
    ClientMapper mapper;

    @Mock
    ClientRepository repository;

    @InjectMocks
    ClientMaintenanceUseCaseImpl useCase;

    @Test
    @DisplayName("USE CASE LAYER ::: Create client successfully")
    void createClient() {
        var request = Mockito.mock(ClientRequest.class);
        var client = Mockito.mock(Client.class);
        client.setRole(U.getValue());

        when(repository.findByEmail(anyString())).thenReturn(Optional.empty());
        when(mapper.toEntity(request)).thenReturn(client);
        when(repository.save(client)).thenReturn(client);

        useCase.createClient(request);
    }

    @Test
    @DisplayName("USE CASE LAYER ::: Create client with error")
    void clientDataIntegrityException() {
        var client = Mockito.mock(Client.class);
        when(repository.findByEmail(anyString())).thenReturn(Optional.of(client));
        assertThrows(ClientDataIntegrityException.class, () -> useCase.createClient(any()));
    }
}
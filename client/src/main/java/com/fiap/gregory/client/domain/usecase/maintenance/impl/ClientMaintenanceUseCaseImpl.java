package com.fiap.gregory.client.domain.usecase.maintenance.impl;

import com.fiap.gregory.client.domain.mapper.ClientMapper;
import com.fiap.gregory.client.domain.usecase.maintenance.ClientMaintenanceUseCase;
import com.fiap.gregory.client.infra.db.repository.ClientRepository;
import com.fiap.gregory.client.rest.dto.request.ClientRequest;
import com.fiap.gregory.client.rest.exceptionhandler.exception.ClientDataIntegrityException;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import static com.fiap.gregory.client.domain.message.ClientMessage.DATA_INTEGRITY;
import static com.fiap.gregory.client.rest.useful.ClientRole.U;

@Service
@AllArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class ClientMaintenanceUseCaseImpl implements ClientMaintenanceUseCase {

    ClientRepository repository;
    ClientMapper mapper;

    @Override
    public void createClient(ClientRequest request) {
        if (clientExists(request.getEmail()))
            throw new ClientDataIntegrityException(DATA_INTEGRITY);

        var client = mapper.toEntity(request);
        client.setRole(U.getValue());
        repository.save(client);
    }

    private boolean clientExists(String email) {
        return repository.findByEmail(email).isPresent();
    }
}

package com.fiap.gregory.client.domain.usecase.query.impl;

import com.fiap.gregory.client.domain.mapper.ClientMapper;
import com.fiap.gregory.client.domain.usecase.query.ClientQueryUseCase;
import com.fiap.gregory.client.infra.db.repository.ClientRepository;
import com.fiap.gregory.client.rest.dto.response.ClientResponse;
import com.fiap.gregory.client.rest.exceptionhandler.exception.ClientNotFoundException;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import static com.fiap.gregory.client.domain.message.ClientMessage.CLIENT_NOT_FOUND;

@Service
@AllArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class ClientQueryUseCaseImpl implements ClientQueryUseCase {

    ClientRepository clientRepository;
    ClientMapper clientMapper;

    @Override
    public ClientResponse getClientById(Long id) {
        if (!clientExists(id)) {
            throw new ClientNotFoundException(CLIENT_NOT_FOUND);
        }

        var response = clientRepository.findById(id).get();
        return clientMapper.toResponse(response);
    }

    private boolean clientExists(Long id) {
        return clientRepository.existsById(id);
    }
}

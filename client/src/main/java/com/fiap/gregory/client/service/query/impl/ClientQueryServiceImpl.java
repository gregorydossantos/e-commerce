package com.fiap.gregory.client.service.query.impl;

import com.fiap.gregory.client.domain.usecase.query.ClientQueryUseCase;
import com.fiap.gregory.client.rest.dto.response.ClientResponse;
import com.fiap.gregory.client.service.query.ClientQueryService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class ClientQueryServiceImpl implements ClientQueryService {

    ClientQueryUseCase clientQueryUseCase;

    @Override
    public ClientResponse getClientById(Long id) {
        return clientQueryUseCase.getClientById(id);
    }
}

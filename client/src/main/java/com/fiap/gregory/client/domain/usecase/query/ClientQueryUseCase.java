package com.fiap.gregory.client.domain.usecase.query;

import com.fiap.gregory.client.rest.dto.response.ClientResponse;

public interface ClientQueryUseCase {

    ClientResponse getClientById(Long id);
}

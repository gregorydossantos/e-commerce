package com.fiap.gregory.client.service.query;

import com.fiap.gregory.client.rest.dto.response.ClientResponse;

public interface ClientQueryService {

    ClientResponse getClientById(Long id);
}

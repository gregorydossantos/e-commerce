package com.fiap.gregory.client.domain.usecase;

import com.fiap.gregory.client.rest.dto.request.ClientRequest;

public interface ClientUseCase {

    void createClient(ClientRequest request);
}

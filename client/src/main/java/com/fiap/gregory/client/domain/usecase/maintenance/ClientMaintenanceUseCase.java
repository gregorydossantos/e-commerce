package com.fiap.gregory.client.domain.usecase.maintenance;

import com.fiap.gregory.client.rest.dto.request.ClientRequest;

public interface ClientMaintenanceUseCase {

    void createClient(ClientRequest request);
}

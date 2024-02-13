package com.fiap.gregory.client.service.maintenance.impl;

import com.fiap.gregory.client.domain.usecase.ClientUseCase;
import com.fiap.gregory.client.rest.dto.request.ClientRequest;
import com.fiap.gregory.client.service.maintenance.ClientService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class ClientServiceImpl implements ClientService {

    ClientUseCase useCase;

    @Override
    public void createClient(ClientRequest request) {
        useCase.createClient(request);
    }
}

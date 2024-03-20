package com.fiap.gregory.client.service.maintenance.impl;

import com.fiap.gregory.client.domain.usecase.maintenance.ClientMaintenanceUseCase;
import com.fiap.gregory.client.rest.dto.request.ClientRequest;
import com.fiap.gregory.client.service.maintenance.ClientMaintenanceService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class ClientMaintenanceServiceImpl implements ClientMaintenanceService {

    ClientMaintenanceUseCase useCase;

    @Override
    public void createClient(ClientRequest request) {
        useCase.createClient(request);
    }
}

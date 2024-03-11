package com.fiap.gregory.itemmanager.service.maintenance.impl;

import com.fiap.gregory.itemmanager.domain.usecase.maintenance.ItemUseCaseMaintenance;
import com.fiap.gregory.itemmanager.rest.dto.request.ItemRequest;
import com.fiap.gregory.itemmanager.rest.dto.response.ItemResponse;
import com.fiap.gregory.itemmanager.service.maintenance.ItemServiceMaintenance;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class ItemServiceMaintenanceImpl implements ItemServiceMaintenance {

    ItemUseCaseMaintenance useCaseMaintenance;

    @Override
    public void createItem(ItemRequest request) {
        useCaseMaintenance.createItem(request);
    }

    @Override
    public ItemResponse updateItem(Long id, ItemRequest request) {
        return useCaseMaintenance.updateItem(id, request);
    }

    @Override
    public void deleteItem(Long id) {
        useCaseMaintenance.deleteItem(id);
    }
}

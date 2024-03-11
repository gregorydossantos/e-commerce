package com.fiap.gregory.itemmanager.domain.usecase.maintenance;

import com.fiap.gregory.itemmanager.rest.dto.request.ItemRequest;
import com.fiap.gregory.itemmanager.rest.dto.response.ItemResponse;

public interface ItemUseCaseMaintenance {

    void createItem(ItemRequest request);

    ItemResponse updateItem(Long id, ItemRequest request);

    void deleteItem(Long id);
}

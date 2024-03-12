package com.fiap.gregory.itemmanager.service.maintenance;

import com.fiap.gregory.itemmanager.rest.dto.request.ItemRequest;
import com.fiap.gregory.itemmanager.rest.dto.response.ItemResponse;

public interface ItemServiceMaintenance {

    void createItem(ItemRequest request);

    ItemResponse updateItem(Long id, ItemRequest request);

    void deleteItem(Long id);
}

package com.fiap.gregory.itemmanager.service.query;

import com.fiap.gregory.itemmanager.rest.dto.response.ItemResponse;

import java.util.List;

public interface ItemServiceQuery {

    List<ItemResponse> getAllItems();

    ItemResponse getOneItemById(Long id);
}

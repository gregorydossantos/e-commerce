package com.fiap.gregory.itemmanager.domain.usecase.query;

import com.fiap.gregory.itemmanager.rest.dto.response.ItemResponse;

import java.util.List;

public interface ItemUseCaseQuery {

    List<ItemResponse> getAllItems();

    ItemResponse getOneItemById(Long id);
}

package com.fiap.gregory.itemmanager.service.query.impl;

import com.fiap.gregory.itemmanager.domain.usecase.query.ItemUseCaseQuery;
import com.fiap.gregory.itemmanager.rest.dto.response.ItemResponse;
import com.fiap.gregory.itemmanager.service.query.ItemServiceQuery;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class ItemServiceQueryImpl implements ItemServiceQuery {

    ItemUseCaseQuery useCaseQuery;

    @Override
    public List<ItemResponse> getAllItems() {
        return useCaseQuery.getAllItems();
    }

    @Override
    public ItemResponse getOneItemById(Long id) {
        return useCaseQuery.getOneItemById(id);
    }
}

package com.fiap.gregory.itemmanager.domain.usecase.query.impl;

import com.fiap.gregory.itemmanager.domain.mapper.ItemMapper;
import com.fiap.gregory.itemmanager.domain.usecase.query.ItemUseCaseQuery;
import com.fiap.gregory.itemmanager.infra.db.repository.ItemRepository;
import com.fiap.gregory.itemmanager.rest.dto.response.ItemResponse;
import com.fiap.gregory.itemmanager.rest.exceptionhandler.exception.DataEmptyOrNullException;
import com.fiap.gregory.itemmanager.rest.exceptionhandler.exception.NotFoundException;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.fiap.gregory.itemmanager.domain.message.ItemMessage.DATA_EMPTY_OR_NULL;
import static com.fiap.gregory.itemmanager.domain.message.ItemMessage.ITEM_NOT_FOUND;

@Service
@AllArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class ItemUseCaseQueryImpl implements ItemUseCaseQuery {

    ItemRepository repository;
    ItemMapper mapper;

    @Override
    public List<ItemResponse> getAllItems() {
        var response = repository.findAll();

        if (response.isEmpty()) {
            throw new NotFoundException(ITEM_NOT_FOUND);
        }

        return mapper.toResponseList(response);
    }

    @Override
    public ItemResponse getOneItemById(Long id) {
        var response = repository.findById(id);

        if (response.isEmpty()) {
            throw new DataEmptyOrNullException(DATA_EMPTY_OR_NULL);
        }

        return mapper.toResponse(response.get());
    }
}

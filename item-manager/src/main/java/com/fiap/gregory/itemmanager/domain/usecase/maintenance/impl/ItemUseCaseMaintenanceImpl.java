package com.fiap.gregory.itemmanager.domain.usecase.maintenance.impl;

import com.fiap.gregory.itemmanager.domain.mapper.ItemMapper;
import com.fiap.gregory.itemmanager.domain.usecase.maintenance.ItemUseCaseMaintenance;
import com.fiap.gregory.itemmanager.infra.db.repository.ItemRepository;
import com.fiap.gregory.itemmanager.rest.dto.request.ItemRequest;
import com.fiap.gregory.itemmanager.rest.dto.response.ItemResponse;
import com.fiap.gregory.itemmanager.rest.exceptionhandler.exception.DataEmptyOrNullException;
import com.fiap.gregory.itemmanager.rest.exceptionhandler.exception.DataIntegrityException;
import com.fiap.gregory.itemmanager.rest.exceptionhandler.exception.NotFoundException;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import static com.fiap.gregory.itemmanager.domain.message.ItemMessage.DATA_EMPTY_OR_NULL;
import static com.fiap.gregory.itemmanager.domain.message.ItemMessage.DATA_INTEGRITY;
import static com.fiap.gregory.itemmanager.domain.message.ItemMessage.ITEM_NOT_FOUND;

@Service
@AllArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class ItemUseCaseMaintenanceImpl implements ItemUseCaseMaintenance {

    ItemRepository repository;
    ItemMapper mapper;

    @Override
    public void createItem(ItemRequest request) {
        if (itemExists(request.getProduct())) {
            throw new DataIntegrityException(DATA_INTEGRITY);
        }

        var item = mapper.toEntity(request);
        repository.save(item);
    }

    @Override
    public ItemResponse updateItem(Long id, ItemRequest request) {
        var item = repository.findById(id);

        if (item.isEmpty()) {
            throw new DataEmptyOrNullException(DATA_EMPTY_OR_NULL);
        }

        var itemUpdate = mapper.toUpdate(item.get(), request);
        repository.save(itemUpdate);

        return mapper.toResponse(itemUpdate);
    }

    @Override
    public void deleteItem(Long id) {
        var response = repository.findById(id);

        if (response.isEmpty()) {
            throw new NotFoundException(ITEM_NOT_FOUND);
        }

        repository.delete(response.get());
    }

    private boolean itemExists(String product) {
        return repository.findByProduct(product).isPresent();
    }

}

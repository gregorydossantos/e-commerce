package com.fiap.gregory.itemmanager.domain.usecase.maintenance.impl;

import com.fiap.gregory.itemmanager.domain.mapper.ItemMapper;
import com.fiap.gregory.itemmanager.infra.db.model.Item;
import com.fiap.gregory.itemmanager.infra.db.repository.ItemRepository;
import com.fiap.gregory.itemmanager.rest.dto.request.ItemRequest;
import com.fiap.gregory.itemmanager.rest.exceptionhandler.exception.ItemDataEmptyOrNullException;
import com.fiap.gregory.itemmanager.rest.exceptionhandler.exception.ItemDataIntegrityException;
import com.fiap.gregory.itemmanager.rest.exceptionhandler.exception.ItemNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
@ActiveProfiles("test")
class ItemUseCaseMaintenanceImplTest {

    @Mock
    ItemRepository repository;

    @Mock
    ItemMapper mapper;

    @InjectMocks
    ItemUseCaseMaintenanceImpl useCaseMaintenance;

    ItemRequest request;
    Item item;

    @BeforeEach
    void setUp() {
        request = Mockito.mock(ItemRequest.class);
        item = Mockito.mock(Item.class);
    }

    @Test
    @DisplayName("USE CASE LAYER ::: Create item successfully")
    void createItem() {
        when(repository.findByProduct(anyString())).thenReturn(Optional.ofNullable(item));
        when(mapper.toEntity(request)).thenReturn(item);

        useCaseMaintenance.createItem(request);
        verify(repository).save(item);
    }

    @Test
    @DisplayName("USE CASE LAYER ::: Update item successfully")
    void updateItem() {
        when(repository.findById(anyLong())).thenReturn(Optional.ofNullable(item));
        when(mapper.toUpdate(item, request)).thenReturn(item);

        useCaseMaintenance.updateItem(1L, request);
        verify(repository).save(item);
    }

    @Test
    @DisplayName("USE CASE LAYER ::: Delete item successfully")
    void deleteItem() {
        when(repository.findById(anyLong())).thenReturn(Optional.ofNullable(item));

        useCaseMaintenance.deleteItem(1L);
        verify(repository).delete(item);
    }

    @Test
    @DisplayName("USE CASE LAYER ::: ItemDataIntegrityException")
    void throwItemDataIntegrityException() {
        when(repository.findByProduct(request.getProduct())).thenReturn(Optional.ofNullable(item));
        assertThrows(ItemDataIntegrityException.class, () -> useCaseMaintenance.createItem(request));
    }

    @Test
    @DisplayName("USE CASE LAYER ::: ItemDataEmptyOrNullException")
    void throwItemDataEmptyOrNullException() {
        when(repository.findById(anyLong())).thenReturn(Optional.ofNullable(null));
        assertThrows(ItemDataEmptyOrNullException.class, () -> useCaseMaintenance.updateItem(1L, request));
    }

    @Test
    @DisplayName("USE CASE LAYER ::: ItemNotFoundException")
    void throwItemNotFoundException() {
        when(repository.findById(anyLong())).thenReturn(Optional.ofNullable(null));
        assertThrows(ItemNotFoundException.class, () -> useCaseMaintenance.deleteItem(1L));
    }
}
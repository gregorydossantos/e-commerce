package com.fiap.gregory.itemmanager.domain.usecase.query.impl;

import com.fiap.gregory.itemmanager.domain.mapper.ItemMapper;
import com.fiap.gregory.itemmanager.infra.db.model.Item;
import com.fiap.gregory.itemmanager.infra.db.repository.ItemRepository;
import com.fiap.gregory.itemmanager.rest.dto.response.ItemResponse;
import com.fiap.gregory.itemmanager.rest.exceptionhandler.exception.ItemDataEmptyOrNullException;
import com.fiap.gregory.itemmanager.rest.exceptionhandler.exception.ItemNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

@SpringBootTest
@ActiveProfiles("test")
class ItemUseCaseQueryImplTest {

    @Mock
    ItemRepository repository;

    @Mock
    ItemMapper mapper;

    @InjectMocks
    ItemUseCaseQueryImpl useCaseQuery;

    @Test
    @DisplayName("USE CASE LAYER ::: Get all items successfully")
    void getAllItems() {
        var item = Mockito.mock(Item.class);
        when(repository.findAll()).thenReturn(List.of(item));

        var response = useCaseQuery.getAllItems();
        assertNotNull(response);
    }

    @Test
    @DisplayName("USE CASE LAYER ::: ItemNotFoundException")
    void throwItemNotFoundException() {
        when(repository.findAll()).thenReturn(new ArrayList<>());
        assertThrows(ItemNotFoundException.class, () -> useCaseQuery.getAllItems());
    }

    @Test
    @DisplayName("USE CASE LAYER ::: Get a item successfully")
    void getOneItemById() {
        var item = Mockito.mock(Item.class);
        var itemResponse = Mockito.mock(ItemResponse.class);
        when(repository.findById(anyLong())).thenReturn(Optional.ofNullable(item));
        when(mapper.toResponse(item)).thenReturn(itemResponse);

        var response = useCaseQuery.getOneItemById(1L);
        assertNotNull(response);
    }

    @Test
    @DisplayName("USE CASE LAYER ::: ItemDataEmptyOrNullException")
    void throwItemDataEmptyOrNullException() {
        when(repository.findById(anyLong())).thenReturn(Optional.ofNullable(null));
        assertThrows(ItemDataEmptyOrNullException.class, () -> useCaseQuery.getOneItemById(1L));
    }
}
package com.fiap.gregory.itemmanager.service.query.impl;

import com.fiap.gregory.itemmanager.domain.usecase.query.ItemUseCaseQuery;
import com.fiap.gregory.itemmanager.rest.dto.response.ItemResponse;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

@SpringBootTest
@ActiveProfiles("test")
class ItemServiceQueryImplTest {

    @Mock
    ItemUseCaseQuery useCaseQuery;

    @InjectMocks
    ItemServiceQueryImpl serviceQuery;

    @Test
    void getAllItems() {
        var itemResponse = Mockito.mock(ItemResponse.class);
        when(serviceQuery.getAllItems()).thenReturn(List.of(itemResponse));

        var response = serviceQuery.getAllItems();
        assertNotNull(response);
    }

    @Test
    void getOneItemById() {
        var itemResponse = Mockito.mock(ItemResponse.class);
        when(serviceQuery.getOneItemById(1L)).thenReturn(itemResponse);

        var response = serviceQuery.getOneItemById(1L);
        assertNotNull(response);
    }
}
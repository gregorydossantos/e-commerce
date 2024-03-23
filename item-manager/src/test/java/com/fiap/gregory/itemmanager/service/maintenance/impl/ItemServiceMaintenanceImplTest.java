package com.fiap.gregory.itemmanager.service.maintenance.impl;

import com.fiap.gregory.itemmanager.domain.usecase.maintenance.ItemUseCaseMaintenance;
import com.fiap.gregory.itemmanager.rest.dto.request.ItemRequest;
import com.fiap.gregory.itemmanager.rest.dto.response.ItemResponse;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.mockito.Mockito.*;

@SpringBootTest
@ActiveProfiles("test")
class ItemServiceMaintenanceImplTest {

    @Mock
    ItemUseCaseMaintenance useCaseMaintenance;

    @InjectMocks
    ItemServiceMaintenanceImpl serviceMaintenance;

    @Test
    @DisplayName("SERVICE LAYER ::: Create Item")
    void createItem() {
        var request = Mockito.mock(ItemRequest.class);
        doNothing().when(useCaseMaintenance).createItem(request);

        serviceMaintenance.createItem(request);
        verify(useCaseMaintenance).createItem(request);
    }

    @Test
    @DisplayName("SERVICE LAYER ::: Update Item")
    void updateItem() {
        var request = Mockito.mock(ItemRequest.class);
        var itemResponse = Mockito.mock(ItemResponse.class);
        when(useCaseMaintenance.updateItem(1L, request)).thenReturn(itemResponse);

        serviceMaintenance.updateItem(1L, request);
        verify(useCaseMaintenance).updateItem(1L, request);
    }

    @Test
    @DisplayName("SERVICE LAYER ::: Delete Item")
    void deleteItem() {
        doNothing().when(useCaseMaintenance).deleteItem(1L);

        serviceMaintenance.deleteItem(1L);
        verify(useCaseMaintenance).deleteItem(1L);
    }
}
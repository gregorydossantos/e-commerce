package com.fiap.gregory.itemmanager.rest.maintenance.impl;

import com.fiap.gregory.itemmanager.rest.dto.request.ItemRequest;
import com.fiap.gregory.itemmanager.rest.dto.response.ItemResponse;
import com.fiap.gregory.itemmanager.service.maintenance.ItemServiceMaintenance;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.ActiveProfiles;

import static com.fiap.gregory.itemmanager.domain.message.ItemMessage.PATH_ITEM;
import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

@ActiveProfiles("test")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ItemMaintenanceControllerImplTest {

    private static final String PATH_ITEM_ID = PATH_ITEM + "/1";

    @LocalServerPort
    int port;

    @MockBean
    ItemServiceMaintenance serviceMaintenance;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        RestAssured.port = port;
    }

    @Test
    @DisplayName("REST LAYER - Create Item ::: Should be return a http status 201 - CREATED")
    void createItem() {
        var request = Mockito.mock(ItemRequest.class);
        doNothing().when(serviceMaintenance).createItem(any(ItemRequest.class));

        given()
                .contentType(ContentType.JSON)
                .body(request)
                .when().post(PATH_ITEM)
                .then().statusCode(HttpStatus.CREATED.value());

        verify(serviceMaintenance).createItem(any(ItemRequest.class));
    }

    @Test
    @DisplayName("REST LAYER - Update Item ::: Should be return a http status 200 - OK")
    void updateItem() {
        var request = Mockito.mock(ItemRequest.class);
        var response = Mockito.mock(ItemResponse.class);
        when(serviceMaintenance.updateItem(1L, request)).thenReturn(response);

        given()
                .contentType(ContentType.JSON)
                .body(request)
                .when().put(PATH_ITEM_ID)
                .then().statusCode(HttpStatus.OK.value());

        verify(serviceMaintenance).updateItem(anyLong(), any(ItemRequest.class));
    }

    @Test
    @DisplayName("REST LAYER - Delete Item ::: Should be return a http status 200 - OK")
    void deleteItem() {
        doNothing().when(serviceMaintenance).deleteItem(anyLong());

        given()
                .contentType(ContentType.JSON)
                .when().delete(PATH_ITEM_ID)
                .then().statusCode(HttpStatus.OK.value());

        verify(serviceMaintenance).deleteItem(anyLong());
    }
}
package com.fiap.gregory.itemmanager.rest.query.impl;

import com.fiap.gregory.itemmanager.rest.dto.request.ItemRequest;
import com.fiap.gregory.itemmanager.rest.dto.response.ItemResponse;
import com.fiap.gregory.itemmanager.service.query.ItemServiceQuery;
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

import java.util.List;

import static com.fiap.gregory.itemmanager.domain.message.ItemMessage.PATH_ITEM;
import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ActiveProfiles("test")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ItemQueryControllerImplTest {

    private static final String PATH_ITEM_ID = PATH_ITEM + "/1";

    @LocalServerPort
    int port;

    @MockBean
    ItemServiceQuery serviceQuery;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        RestAssured.port = port;
    }

    @Test
    @DisplayName("REST LAYER - Get all Items ::: Should be return a http status 200 - OK")
    void getAllItems() {
        var item = Mockito.mock(ItemResponse.class);
        when(serviceQuery.getAllItems()).thenReturn(List.of(item));

        given()
                .contentType(ContentType.JSON)
                .when().get(PATH_ITEM)
                .then().statusCode(HttpStatus.OK.value());

        verify(serviceQuery).getAllItems();
    }

    @Test
    @DisplayName("REST LAYER - Get one Item ::: Should be return a http status 200 - OK")
    void getOneItemById() {
        var item = Mockito.mock(ItemResponse.class);
        when(serviceQuery.getOneItemById(1L)).thenReturn(item);

        given()
                .contentType(ContentType.JSON)
                .when().get(PATH_ITEM_ID)
                .then().statusCode(HttpStatus.OK.value());

        verify(serviceQuery).getOneItemById(1L);
    }
}
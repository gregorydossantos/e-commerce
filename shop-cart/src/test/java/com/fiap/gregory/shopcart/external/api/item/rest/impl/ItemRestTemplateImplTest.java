package com.fiap.gregory.shopcart.external.api.item.rest.impl;

import com.fiap.gregory.shopcart.external.api.client.response.ClientResponse;
import com.fiap.gregory.shopcart.external.api.item.response.ItemResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
class ItemRestTemplateImplTest {

    @Mock
    ItemRestTemplateImpl itemRestTemplate;

    final String PATH_API_ITEM = "http://localhost:8082/v1/item-manager";
    final String PATH_API_ITEM_ID = PATH_API_ITEM + "/1";

    private RestTemplate restTemplate;

    @BeforeEach
    void setUp() {
        restTemplate = new RestTemplate();
    }


    @Test
    void getItemById() {
        var itemResponse = Mockito.mock(ItemResponse.class);
        when(itemRestTemplate.getItemById("1")).thenReturn(itemResponse);

        ItemResponse response = restTemplate.getForObject(PATH_API_ITEM_ID, ItemResponse.class);
        assertNotNull(response);
    }
}
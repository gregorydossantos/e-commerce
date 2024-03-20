package com.fiap.gregory.shopcart.external.api.item.rest.impl;

import com.fiap.gregory.shopcart.external.api.item.response.ItemResponse;
import com.fiap.gregory.shopcart.external.api.item.rest.ItemRestTemplate;
import org.springframework.web.client.RestTemplate;

public class ItemRestTemplateImpl implements ItemRestTemplate {

    private static final String PATH_API_ITEM = "http://localhost:8082/v1/item/";

    @Override
    public ItemResponse getItemById(Long id) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(PATH_API_ITEM + id, ItemResponse.class);
    }
}

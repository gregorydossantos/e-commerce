package com.fiap.gregory.shopcart.external.api.item.rest.impl;

import com.fiap.gregory.shopcart.external.api.item.response.ItemResponse;
import com.fiap.gregory.shopcart.external.api.item.rest.ItemRestTemplate;
import com.fiap.gregory.shopcart.rest.exceptionhandler.exception.ShopCartNotFoundException;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Objects;

import static com.fiap.gregory.shopcart.domain.message.ShopCartMessage.ITEM_NOT_FOUND;

@RestController
public class ItemRestTemplateImpl implements ItemRestTemplate {

    private static final String PATH_API_ITEM = "http://localhost:8082/v1/item-manager/";

    @Override
    public ItemResponse getItemById(String id) {
        final String PATH_API_ITEM_ID = PATH_API_ITEM + id;
        RestTemplate restTemplate = new RestTemplate();
        var response = restTemplate.getForObject(PATH_API_ITEM_ID, ItemResponse.class);

        if (Objects.isNull(response)) {
            throw new ShopCartNotFoundException(ITEM_NOT_FOUND);
        }

        return response;
    }
}

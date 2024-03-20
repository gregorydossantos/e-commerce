package com.fiap.gregory.shopcart.external.api.item.rest;

import com.fiap.gregory.shopcart.external.api.item.response.ItemResponse;

public interface ItemRestTemplate {

    ItemResponse getItemById(Long id);
}

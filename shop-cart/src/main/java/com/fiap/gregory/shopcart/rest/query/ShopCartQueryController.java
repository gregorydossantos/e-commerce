package com.fiap.gregory.shopcart.rest.query;

import com.fiap.gregory.shopcart.rest.dto.response.ShopCartResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

public interface ShopCartQueryController {

    @GetMapping(value = "{id}", consumes = APPLICATION_JSON_VALUE)
    ResponseEntity<ShopCartResponse> getShopCartById(@PathVariable("id") Long id);
}

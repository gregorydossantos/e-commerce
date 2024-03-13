package com.fiap.gregory.shopcart.rest.maintenance;

import com.fiap.gregory.shopcart.rest.dto.request.ShopCartRequest;
import com.fiap.gregory.shopcart.rest.dto.response.ShopCartResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

public interface ShopCartMaintenanceController {

    @PostMapping(consumes = APPLICATION_JSON_VALUE)
    ResponseEntity<Void> createShopCart(@RequestBody ShopCartRequest request);

    @PutMapping(value = "{id}", consumes = APPLICATION_JSON_VALUE)
    ResponseEntity<ShopCartResponse> increaseProduct(@PathVariable("id") Long id, @RequestBody ShopCartRequest request);

    @DeleteMapping(value = "{id}", consumes = APPLICATION_JSON_VALUE)
    ResponseEntity<Void> deleteProduct(@PathVariable("id") Long id);
}

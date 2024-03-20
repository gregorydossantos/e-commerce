package com.fiap.gregory.shopcart.rest.query.impl;

import com.fiap.gregory.shopcart.rest.dto.response.ShopCartResponse;
import com.fiap.gregory.shopcart.rest.query.ShopCartQueryController;
import com.fiap.gregory.shopcart.service.query.ShopCartServiceQuery;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.fiap.gregory.shopcart.domain.message.ShopCartMessage.PATH_SHOP_CART;

@RestController
@AllArgsConstructor
@Tag(name = "Shopping Cart Controller")
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@RequestMapping(value = PATH_SHOP_CART, produces = {"application/json"})
public class ShopCartQueryControllerImpl implements ShopCartQueryController {

    ShopCartServiceQuery shopCartServiceQuery;

    @Operation(summary = "Get a shopping cart", method = "GET")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully get a shopping cart"),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "404", description = "Not Found"),
            @ApiResponse(responseCode = "500", description = "Internal error")
    })
    @Override
    public ResponseEntity<ShopCartResponse> getShopCartById(Long id) {
        var response = shopCartServiceQuery.getShopCartById(id);
        return ResponseEntity.ok().body(response);
    }
}

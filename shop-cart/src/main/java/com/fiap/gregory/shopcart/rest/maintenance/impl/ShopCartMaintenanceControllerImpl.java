package com.fiap.gregory.shopcart.rest.maintenance.impl;

import com.fiap.gregory.shopcart.rest.dto.request.ShopCartRequest;
import com.fiap.gregory.shopcart.rest.dto.response.ShopCartResponse;
import com.fiap.gregory.shopcart.rest.maintenance.ShopCartMaintenanceController;
import com.fiap.gregory.shopcart.service.maintenance.ShopCartServiceMaintenance;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.fiap.gregory.shopcart.domain.message.ShopCartMessage.PATH_SHOP_CART;

@RestController
@AllArgsConstructor
@Tag(name = "Shopping Cart Controller")
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@RequestMapping(value = PATH_SHOP_CART, produces = {"application/json"})
public class ShopCartMaintenanceControllerImpl implements ShopCartMaintenanceController {

    ShopCartServiceMaintenance serviceMaintenance;

    @Operation(summary = "Create a shopping cart", method = "POST")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Successfully created shopping cart"),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "404", description = "Not Found"),
            @ApiResponse(responseCode = "500", description = "Internal error")
    })
    @Override
    public ResponseEntity<Void> createShopCart(ShopCartRequest request) {
        serviceMaintenance.createShopCart(request);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @Operation(summary = "Add products in the shopping cart", method = "PUT")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully update shopping cart"),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "404", description = "Not Found"),
            @ApiResponse(responseCode = "500", description = "Internal error")
    })
    @Override
    public ResponseEntity<ShopCartResponse> increaseProduct(Long id, ShopCartRequest request) {
        var response = serviceMaintenance.increaseProduct(id, request);
        return ResponseEntity.ok().body(response);
    }

    @Operation(summary = "Delete products from shopping cart", method = "DELETE")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully delete products from shopping cart"),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "404", description = "Not Found"),
            @ApiResponse(responseCode = "500", description = "Internal error")
    })
    @Override
    public ResponseEntity<Void> deleteProduct(Long id) {
        serviceMaintenance.deleteProduct(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}

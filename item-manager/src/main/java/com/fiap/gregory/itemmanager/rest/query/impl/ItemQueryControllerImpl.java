package com.fiap.gregory.itemmanager.rest.query.impl;

import com.fiap.gregory.itemmanager.rest.dto.response.ItemResponse;
import com.fiap.gregory.itemmanager.rest.query.ItemQueryController;
import com.fiap.gregory.itemmanager.service.query.ItemServiceQuery;
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

import java.util.List;

import static com.fiap.gregory.itemmanager.domain.message.ItemMessage.PATH_ITEM;

@RestController
@AllArgsConstructor
@Tag(name = "Item Controller")
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@RequestMapping(value = PATH_ITEM, produces = {"application/json"})
public class ItemQueryControllerImpl implements ItemQueryController {

    ItemServiceQuery serviceQuery;

    @Operation(summary = "List all items", method = "GET")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully listed items"),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "404", description = "Not Found"),
            @ApiResponse(responseCode = "500", description = "Internal error")
    })
    @Override
    public ResponseEntity<List<ItemResponse>> getAllItems() {
        var response = serviceQuery.getAllItems();
        return ResponseEntity.ok().body(response);
    }

    @Operation(summary = "List one item by id", method = "GET")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully get one item"),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "404", description = "Not Found"),
            @ApiResponse(responseCode = "500", description = "Internal error")
    })
    @Override
    public ResponseEntity<ItemResponse> getOneItemById(Long id) {
        var response = serviceQuery.getOneItemById(id);
        return ResponseEntity.ok().body(response);
    }
}

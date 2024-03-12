package com.fiap.gregory.itemmanager.rest.maintenance.impl;

import com.fiap.gregory.itemmanager.rest.dto.request.ItemRequest;
import com.fiap.gregory.itemmanager.rest.dto.response.ItemResponse;
import com.fiap.gregory.itemmanager.rest.maintenance.ItemMaintenanceController;
import com.fiap.gregory.itemmanager.service.maintenance.ItemServiceMaintenance;
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

import static com.fiap.gregory.itemmanager.domain.message.ItemMessage.PATH_ITEM;

@RestController
@AllArgsConstructor
@Tag(name = "Item Controller")
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@RequestMapping(value = PATH_ITEM, produces = {"application/json"})
public class ItemMaintenanceControllerImpl implements ItemMaintenanceController {

    ItemServiceMaintenance serviceMaintenance;

    @Operation(summary = "Create a item", method = "POST")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Successfully created item"),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "404", description = "Not Found"),
            @ApiResponse(responseCode = "500", description = "Internal error")
    })
    @Override
    public ResponseEntity<Void> createItem(ItemRequest request) {
        serviceMaintenance.createItem(request);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @Operation(summary = "Update a item", method = "PUT")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully update item"),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "404", description = "Not Found"),
            @ApiResponse(responseCode = "500", description = "Internal error")
    })
    @Override
    public ResponseEntity<ItemResponse> updateItem(Long id, ItemRequest request) {
        var response = serviceMaintenance.updateItem(id, request);
        return ResponseEntity.ok().body(response);
    }

    @Operation(summary = "Delete a item", method = "DELETE")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully delete item"),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "404", description = "Not Found"),
            @ApiResponse(responseCode = "500", description = "Internal error")
    })
    @Override
    public ResponseEntity<Void> deleteItem(Long id) {
        serviceMaintenance.deleteItem(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}

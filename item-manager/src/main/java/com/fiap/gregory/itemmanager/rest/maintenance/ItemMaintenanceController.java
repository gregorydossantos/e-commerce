package com.fiap.gregory.itemmanager.rest.maintenance;

import com.fiap.gregory.itemmanager.rest.dto.request.ItemRequest;
import com.fiap.gregory.itemmanager.rest.dto.response.ItemResponse;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

public interface ItemMaintenanceController {

    @PostMapping(consumes = APPLICATION_JSON_VALUE)
    ResponseEntity<Void> createItem(@RequestBody @Valid ItemRequest request);

    @PutMapping(consumes = APPLICATION_JSON_VALUE)
    ResponseEntity<ItemResponse> updateItem(@PathVariable("id") Long id, @RequestBody @Valid ItemRequest request);

    @DeleteMapping(consumes = APPLICATION_JSON_VALUE)
    ResponseEntity<Void> deleteItem(@PathVariable("id") Long id);
}

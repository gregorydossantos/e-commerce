package com.fiap.gregory.itemmanager.rest.query;

import com.fiap.gregory.itemmanager.rest.dto.request.ItemRequest;
import com.fiap.gregory.itemmanager.rest.dto.response.ItemResponse;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

public interface ItemQueryController {

    @GetMapping(consumes = APPLICATION_JSON_VALUE)
    ResponseEntity<List<ItemResponse>> getAllItems();

    @GetMapping(value = "{id}",consumes = APPLICATION_JSON_VALUE)
    ResponseEntity<ItemResponse> getOneItemById(@PathVariable("id") Long id);
}

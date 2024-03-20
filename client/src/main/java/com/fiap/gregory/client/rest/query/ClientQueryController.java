package com.fiap.gregory.client.rest.query;

import com.fiap.gregory.client.rest.dto.response.ClientResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

public interface ClientQueryController {

    @GetMapping(value = "{id}", consumes = APPLICATION_JSON_VALUE)
    ResponseEntity<ClientResponse> getClientById(@PathVariable("id") Long id);
}

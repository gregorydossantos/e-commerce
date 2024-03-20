package com.fiap.gregory.client.rest.maintenance;

import com.fiap.gregory.client.rest.dto.request.ClientRequest;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

public interface ClientMaintenanceController {

    @PostMapping(consumes = APPLICATION_JSON_VALUE)
    ResponseEntity<Void> createClient(@RequestBody @Valid ClientRequest request);
}


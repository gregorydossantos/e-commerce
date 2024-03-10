package com.fiap.gregory.client.rest.maintenance.impl;

import com.fiap.gregory.client.rest.dto.request.ClientRequest;
import com.fiap.gregory.client.rest.maintenance.ClientController;
import com.fiap.gregory.client.service.maintenance.ClientService;
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

import static com.fiap.gregory.client.domain.message.ClientMessage.PATH_CLIENT;

@RestController
@AllArgsConstructor
@Tag(name = "Client Controller")
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@RequestMapping(value = PATH_CLIENT, produces = {"application/json"})
public class ClientControllerImpl implements ClientController {

    ClientService service;

    @Operation(summary = "Create a client", method = "POST")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Successfully created address"),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "404", description = "Not Found"),
            @ApiResponse(responseCode = "500", description = "Internal error")
    })
    @Override
    public ResponseEntity<Void> createClient(ClientRequest request) {
        service.createClient(request);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}

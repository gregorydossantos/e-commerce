package com.fiap.gregory.client.rest.query.impl;

import com.fiap.gregory.client.rest.dto.response.ClientResponse;
import com.fiap.gregory.client.rest.query.ClientQueryController;
import com.fiap.gregory.client.service.query.ClientQueryService;
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

import static com.fiap.gregory.client.domain.message.ClientMessage.PATH_CLIENT;

@RestController
@AllArgsConstructor
@Tag(name = "Client Controller")
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@RequestMapping(value = PATH_CLIENT, produces = {"application/json"})
public class ClientQueryControllerImpl implements ClientQueryController {

    ClientQueryService clientQueryService;

    @Operation(summary = "Get a client", method = "GET")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Return a client"),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "404", description = "Not Found"),
            @ApiResponse(responseCode = "500", description = "Internal error")
    })
    @Override
    public ResponseEntity<ClientResponse> getClientById(Long id) {
        var response = clientQueryService.getClientById(id);
        return ResponseEntity.ok().body(response);
    }
}

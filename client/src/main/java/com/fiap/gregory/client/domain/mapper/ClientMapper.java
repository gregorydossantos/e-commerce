package com.fiap.gregory.client.domain.mapper;

import com.fiap.gregory.client.infra.db.model.Client;
import com.fiap.gregory.client.rest.dto.request.ClientRequest;
import com.fiap.gregory.client.rest.dto.response.ClientResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ClientMapper {

    Client toEntity(ClientRequest request);

    ClientResponse toResponse(Client client);
}

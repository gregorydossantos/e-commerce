package com.fiap.gregory.client.domain.mapper;

import com.fiap.gregory.client.infra.db.model.Client;
import com.fiap.gregory.client.rest.dto.request.ClientRequest;
import com.fiap.gregory.client.rest.dto.response.ClientResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ClientMapper {

    @Mapping(target = "name", source = "name")
    @Mapping(target = "lastName", source = "lastName")
    @Mapping(target = "email", source = "email")
    @Mapping(target = "password", source = "password")
    Client toEntity(ClientRequest request);

    ClientResponse toResponse(Client client);

}

package com.fiap.gregory.shopcart.domain.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import static com.fasterxml.jackson.annotation.JsonProperty.Access.WRITE_ONLY;

@Data
public class ClientDTO {
    @JsonProperty(access = WRITE_ONLY)
    Long id;
    String name;
    String lastName;
    String email;
}

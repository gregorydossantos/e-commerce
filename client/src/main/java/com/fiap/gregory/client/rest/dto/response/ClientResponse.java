package com.fiap.gregory.client.rest.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import static com.fasterxml.jackson.annotation.JsonProperty.Access.WRITE_ONLY;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ClientResponse {

    @JsonProperty(access = WRITE_ONLY)
    Long id;
    String name;
    String lastName;
    String email;
    @JsonProperty(access = WRITE_ONLY)
    Integer password;
    Character role;
}

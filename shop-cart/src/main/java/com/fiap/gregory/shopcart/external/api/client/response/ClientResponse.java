package com.fiap.gregory.shopcart.external.api.client.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

import static com.fasterxml.jackson.annotation.JsonProperty.Access.WRITE_ONLY;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ClientResponse implements Serializable {

    @JsonProperty(access = WRITE_ONLY)
    private Long id;
    private String name;
    private String lastName;
    private String email;
    @JsonProperty(access = WRITE_ONLY)
    private Integer password;
    private String role;
}

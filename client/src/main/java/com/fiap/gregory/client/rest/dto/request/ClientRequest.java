package com.fiap.gregory.client.rest.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Data;

import static com.fiap.gregory.client.domain.message.ClientMessage.EMAIL_INVALID;
import static com.fiap.gregory.client.domain.message.ClientMessage.FIELD_MANDATORY;
import static com.fiap.gregory.client.domain.message.ClientMessage.LAST_NAME_SIZE;
import static com.fiap.gregory.client.domain.message.ClientMessage.NAME_SIZE;
import static com.fiap.gregory.client.domain.message.ClientMessage.PASSWORD_SIZE;

@Data
@Builder
@NotNull(message = FIELD_MANDATORY)
@NotEmpty(message = FIELD_MANDATORY)
public class ClientRequest {

    @Size(max = 50, message = NAME_SIZE)
    private String name;

    @Size(max = 50, message = LAST_NAME_SIZE)
    private String lastName;

    @Email(message = EMAIL_INVALID)
    private String email;

    @Size(min = 10, max = 10, message = PASSWORD_SIZE)
    private Integer password;
}

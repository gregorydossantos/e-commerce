package com.fiap.gregory.shopcart.rest.dto.request;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

import static com.fiap.gregory.client.domain.message.ClientMessage.FIELD_MANDATORY;

@Data
@Builder
@NotNull(message = FIELD_MANDATORY)
@NotEmpty(message = FIELD_MANDATORY)
public class ShopCartRequest {

    private Integer amount;
    private BigDecimal total;
    private Long clientId;
    private Long itemId;
}

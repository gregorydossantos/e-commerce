package com.fiap.gregory.itemmanager.rest.dto.request;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

import static com.fiap.gregory.itemmanager.domain.message.ItemMessage.FIELD_MANDATORY;
import static com.fiap.gregory.itemmanager.domain.message.ItemMessage.PRICE_SIZE;
import static com.fiap.gregory.itemmanager.domain.message.ItemMessage.PRODUCT_SIZE;

@Data
@Builder
@NotNull(message = FIELD_MANDATORY)
@NotEmpty(message = FIELD_MANDATORY)
public class ItemRequest {

    @Size(max = 100, message = PRODUCT_SIZE)
    private String product;

    @Size(max = 10, message = PRICE_SIZE)
    private BigDecimal price;
}

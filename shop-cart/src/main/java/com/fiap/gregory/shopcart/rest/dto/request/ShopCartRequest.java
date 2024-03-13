package com.fiap.gregory.shopcart.rest.dto.request;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

import static com.fiap.gregory.shopcart.domain.message.ShopCartMessage.*;

@Data
@Builder
@NotNull(message = FIELD_MANDATORY)
@NotEmpty(message = FIELD_MANDATORY)
public class ShopCartRequest {

    @Min(value = 1, message = INVALID_AMOUNT)
    private Integer amount;

    @Digits(integer = 10, fraction = 2, message = INVALID_PRICE)
    private BigDecimal total;

    private Long clientId;
    private Long itemId;
}

package com.fiap.gregory.shopcart.rest.dto.request;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

import static com.fiap.gregory.shopcart.domain.message.ShopCartMessage.*;

@Data
@Builder
public class ShopCartRequest {

    private String idShopCart;

    @NotNull(message = FIELD_MANDATORY)
    @NotEmpty(message = FIELD_MANDATORY)
    @Min(value = 1, message = INVALID_AMOUNT)
    private Integer amount;

    @NotNull(message = FIELD_MANDATORY)
    @NotEmpty(message = FIELD_MANDATORY)
    @Digits(integer = 10, fraction = 2, message = INVALID_PRICE)
    private BigDecimal total;

    @NotNull(message = FIELD_MANDATORY)
    @NotEmpty(message = FIELD_MANDATORY)
    private Long clientId;

    @NotNull(message = FIELD_MANDATORY)
    @NotEmpty(message = FIELD_MANDATORY)
    private Long itemId;
}

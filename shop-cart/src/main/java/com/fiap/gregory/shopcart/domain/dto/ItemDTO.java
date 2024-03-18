package com.fiap.gregory.shopcart.domain.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.math.BigDecimal;

import static com.fasterxml.jackson.annotation.JsonProperty.Access.WRITE_ONLY;

@Data
public class ItemDTO {
    @JsonProperty(access = WRITE_ONLY)
    Long id;
    String product;
    BigDecimal price;
}

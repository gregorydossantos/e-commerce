package com.fiap.gregory.shopcart.rest.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fiap.gregory.shopcart.domain.dto.ClientDTO;
import com.fiap.gregory.shopcart.domain.dto.ItemDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

import static com.fasterxml.jackson.annotation.JsonProperty.Access.WRITE_ONLY;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ShopCartResponse {

    @JsonProperty(access = WRITE_ONLY)
    private Long id;
    private Integer amount;
    private BigDecimal total;
    private Long clientId;
    private Long itemId;
}

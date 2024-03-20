package com.fiap.gregory.payment.external.api.shoppingcart.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

import static com.fasterxml.jackson.annotation.JsonProperty.Access.WRITE_ONLY;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ShopCartResponse implements Serializable {

    @JsonProperty(access = WRITE_ONLY)
    private Long id;
    private Integer amount;
    private BigDecimal total;
    private Long clientId;
    private Long itemId;
}

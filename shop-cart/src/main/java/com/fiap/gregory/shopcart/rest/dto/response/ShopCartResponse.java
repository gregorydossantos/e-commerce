package com.fiap.gregory.shopcart.rest.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fiap.gregory.client.infra.db.model.Client;
import com.fiap.gregory.itemmanager.rest.dto.response.ItemResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

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
    private Client client;
    private ItemResponse item;
}

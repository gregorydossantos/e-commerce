package com.fiap.gregory.shopcart.external.api.item.response;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

@Data
public class ItemResponse implements Serializable {

    private Long id;
    private String idShopCart;
    private Integer amount;
    private BigDecimal total;
    private Long clientId;
    private List<Long> itemIds;
}

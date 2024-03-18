package com.fiap.gregory.shopcart.infra.db.model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;
import java.util.List;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Table(name = "tb_shopping_cart")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ShopCart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "id_shop_cart")
    String idShopCart;

    @Column(name = "amount")
    Integer amount;

    @Column(name = "total", precision = 10, scale = 2)
    BigDecimal total;

    @Column(name = "client_id", nullable = false)
    Long clientId;

    @Column(name = "item_id", nullable = false)
    Long itemId;
}

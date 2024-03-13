package com.fiap.gregory.shopcart.infra.db.model;

import com.fiap.gregory.client.infra.db.model.Client;
import com.fiap.gregory.itemmanager.infra.db.model.Item;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;

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

    @Column(name = "amount")
    Integer amount;

    @Column(name = "total", precision = 10, scale = 2)
    BigDecimal total;

    @ManyToOne
    @JoinColumn(name = "client_id")
    Client client;

    @ManyToOne
    @JoinColumn(name = "item_id")
    Item item;
}

package com.fiap.gregory.payment.infra.db.model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Table(name = "tb_payment")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "operation", length = 1)
    String operation;

    @Column(name = "paid")
    Boolean paid;

    @Column(name = "id_shop_cart")
    Long idShopCart;
}

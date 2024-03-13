package com.fiap.gregory.shopcart.infra.db.repository;

import com.fiap.gregory.shopcart.infra.db.model.ShopCart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShopCartRepository extends JpaRepository<ShopCart, Long> {
}

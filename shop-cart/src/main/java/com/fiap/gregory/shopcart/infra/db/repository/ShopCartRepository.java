package com.fiap.gregory.shopcart.infra.db.repository;

import com.fiap.gregory.shopcart.infra.db.model.ShopCart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShopCartRepository extends JpaRepository<ShopCart, Long> {

    ShopCart findByIdShopCart(String idShopCart);

    ShopCart findByIdShopCartAndItemId(String idShopCart, Long itemId);

    List<ShopCart> findAllByIdShopCart(String idShopCart);

    void deleteByItemId(Long itemId);
}

package com.fiap.gregory.itemmanager.infra.db.repository;

import com.fiap.gregory.itemmanager.infra.db.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {
}

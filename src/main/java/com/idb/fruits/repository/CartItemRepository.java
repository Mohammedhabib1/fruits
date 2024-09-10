package com.idb.fruits.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.idb.fruits.model.CartItem;

public interface CartItemRepository extends JpaRepository<CartItem, Long> {
}


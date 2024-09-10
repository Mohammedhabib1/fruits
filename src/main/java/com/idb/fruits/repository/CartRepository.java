package com.idb.fruits.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.idb.fruits.model.Cart;

public interface CartRepository extends JpaRepository<Cart, Long> {
}


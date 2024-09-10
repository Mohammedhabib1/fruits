package com.idb.fruits.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.idb.fruits.model.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
}
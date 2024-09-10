package com.idb.fruits.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.idb.fruits.model.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {
}

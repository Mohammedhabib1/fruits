package com.idb.fruits.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.idb.fruits.model.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
}

package com.idb.fruits.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.idb.fruits.model.Shipment;

public interface ShipmentRepository extends JpaRepository<Shipment, Long> {
}

package com.idb.fruits.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.idb.fruits.model.Address;

public interface AddressRepository extends JpaRepository<Address, Long> {
}

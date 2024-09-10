package com.idb.fruits.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.idb.fruits.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    
}

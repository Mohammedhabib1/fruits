package com.idb.fruits.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.idb.fruits.model.Admin;

public interface AdminRepository extends JpaRepository<Admin, Long> {
}

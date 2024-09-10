package com.idb.fruits.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.idb.fruits.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
}

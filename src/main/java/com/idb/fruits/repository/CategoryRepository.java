package com.idb.fruits.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.idb.fruits.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}

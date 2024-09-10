package com.idb.fruits.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.idb.fruits.model.Review;

public interface ReviewRepository extends JpaRepository<Review, Long> {
}

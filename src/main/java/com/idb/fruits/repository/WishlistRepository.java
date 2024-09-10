package com.idb.fruits.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.idb.fruits.model.Wishlist;

public interface WishlistRepository extends JpaRepository<Wishlist, Long> {
}

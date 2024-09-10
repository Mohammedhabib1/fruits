package com.idb.fruits.service.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idb.fruits.model.Wishlist;
import com.idb.fruits.repository.WishlistRepository;
import com.idb.fruits.service.WishlistService;

@Service
public class WishlistServiceImpl implements WishlistService {
    @Autowired
    private WishlistRepository wishlistRepository;

    @Override
    public Wishlist save(Wishlist wishlist) {
        return wishlistRepository.save(wishlist);
    }

    @Override
    public Optional<Wishlist> findById(Long id) {
        return wishlistRepository.findById(id);
    }

    @Override
    public List<Wishlist> findAll() {
        return wishlistRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        wishlistRepository.deleteById(id);
    }
}
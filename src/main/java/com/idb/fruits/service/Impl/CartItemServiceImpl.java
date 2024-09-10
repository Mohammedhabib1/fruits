package com.idb.fruits.service.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idb.fruits.model.CartItem;
import com.idb.fruits.repository.CartItemRepository;
import com.idb.fruits.service.CartItemService;

@Service
public class CartItemServiceImpl implements CartItemService {

    @Autowired
    private CartItemRepository cartItemRepository;

    @Override
    public List<CartItem> findAll() {
        return cartItemRepository.findAll();
    }

    @Override
    public Optional<CartItem> findById(Long id) {
        return cartItemRepository.findById(id);
    }

    @Override
    public CartItem save(CartItem cartItem) {
        return cartItemRepository.save(cartItem);
    }

    @Override
    public void deleteById(Long id) {
        cartItemRepository.deleteById(id);
    }

  
}

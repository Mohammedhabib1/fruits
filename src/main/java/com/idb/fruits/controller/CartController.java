package com.idb.fruits.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.idb.fruits.model.Cart;
import com.idb.fruits.service.CartService;

@RestController
@RequestMapping("/api/carts")
public class CartController {

    @Autowired
    private CartService cartService;

    @GetMapping
    public List<Cart> getAllCarts() {
        return cartService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cart> getCartById(@PathVariable Long id) {
        Optional<Cart> cart = cartService.findById(id);
        return cart.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Cart createCart(@RequestBody Cart cart) {
        return cartService.save(cart);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cart> updateCart(@PathVariable Long id, @RequestBody Cart cart) {
        if (!cartService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        cart.setId(id);
        return ResponseEntity.ok(cartService.save(cart));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCart(@PathVariable Long id) {
        if (!cartService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        cartService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}

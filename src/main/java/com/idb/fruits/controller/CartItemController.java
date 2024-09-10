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

import com.idb.fruits.model.CartItem;
import com.idb.fruits.service.CartItemService;

@RestController
@RequestMapping("/api/cartItems")
public class CartItemController {

    @Autowired
    private CartItemService cartItemService;

    @GetMapping
    public List<CartItem> getAllCartItems() {
        return cartItemService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CartItem> getCartItemById(@PathVariable Long id) {
        Optional<CartItem> cartItem = cartItemService.findById(id);
        return cartItem.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public CartItem createCartItem(@RequestBody CartItem cartItem) {
        return cartItemService.save(cartItem);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CartItem> updateCartItem(@PathVariable Long id, @RequestBody CartItem cartItem) {
        if (!cartItemService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        cartItem.setId(id);
        return ResponseEntity.ok(cartItemService.save(cartItem));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCartItem(@PathVariable Long id) {
        if (!cartItemService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        cartItemService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}

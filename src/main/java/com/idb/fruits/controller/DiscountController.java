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

import com.idb.fruits.model.Discount;
import com.idb.fruits.service.DiscountService;

@RestController
@RequestMapping("/api/discounts")
public class DiscountController {

    @Autowired
    private DiscountService discountService;

    @GetMapping
    public List<Discount> getAllDiscounts() {
        return discountService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Discount> getDiscountById(@PathVariable Long id) {
        Optional<Discount> discount = discountService.findById(id);
        return discount.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Discount createDiscount(@RequestBody Discount discount) {
        return discountService.save(discount);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Discount> updateDiscount(@PathVariable Long id, @RequestBody Discount discount) {
        if (!discountService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        discount.setId(id);
        return ResponseEntity.ok(discountService.save(discount));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDiscount(@PathVariable Long id) {
        if (!discountService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        discountService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}

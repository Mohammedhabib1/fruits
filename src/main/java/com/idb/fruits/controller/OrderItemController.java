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

import com.idb.fruits.model.OrderItem;
import com.idb.fruits.service.OrderItemService;

@RestController
@RequestMapping("/api/orderItems")
public class OrderItemController {

    @Autowired
    private OrderItemService orderItemService;

    @GetMapping
    public List<OrderItem> getAllOrderItems() {
        return orderItemService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderItem> getOrderItemById(@PathVariable Long id) {
        Optional<OrderItem> orderItem = orderItemService.findById(id);
        return orderItem.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public OrderItem createOrderItem(@RequestBody OrderItem orderItem) {
        return orderItemService.save(orderItem);
    }

    @PutMapping("/{id}")
    public ResponseEntity<OrderItem> updateOrderItem(@PathVariable Long id, @RequestBody OrderItem orderItem) {
        if (!orderItemService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        orderItem.setId(id);
        return ResponseEntity.ok(orderItemService.save(orderItem));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrderItem(@PathVariable Long id) {
        if (!orderItemService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        orderItemService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}

package com.idb.fruits.service.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idb.fruits.model.OrderItem;
import com.idb.fruits.repository.OrderItemRepository;
import com.idb.fruits.service.OrderItemService;

@Service
public class OrderItemServiceImpl implements OrderItemService {

    @Autowired
    private OrderItemRepository orderItemRepository;

    @Override
    public List<OrderItem> findAll() {
        return orderItemRepository.findAll();
    }

    @Override
    public Optional<OrderItem> findById(Long id) {
        return orderItemRepository.findById(id);
    }

    @Override
    public OrderItem save(OrderItem orderItem) {
        return orderItemRepository.save(orderItem);
    }

    @Override
    public void deleteById(Long id) {
        orderItemRepository.deleteById(id);
    }

}

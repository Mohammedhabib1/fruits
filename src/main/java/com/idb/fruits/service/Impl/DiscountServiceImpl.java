package com.idb.fruits.service.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idb.fruits.model.Discount;
import com.idb.fruits.repository.DiscountRepository;
import com.idb.fruits.service.DiscountService;

@Service
public class DiscountServiceImpl implements DiscountService {

    @Autowired
    private DiscountRepository discountRepository;

    @Override
    public List<Discount> findAll() {
        return discountRepository.findAll();
    }

    @Override
    public Optional<Discount> findById(Long id) {
        return discountRepository.findById(id);
    }

    @Override
    public Discount save(Discount discount) {
        return discountRepository.save(discount);
    }

    @Override
    public void deleteById(Long id) {
        discountRepository.deleteById(id);
    }

  
}


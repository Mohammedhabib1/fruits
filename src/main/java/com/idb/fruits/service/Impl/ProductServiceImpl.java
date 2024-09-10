package com.idb.fruits.service.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.idb.fruits.model.Product;
import com.idb.fruits.repository.ProductRepository;
import com.idb.fruits.service.ProductService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Override
    public Product save(Product product) {
        return productRepository.save(product);

    }

    // public Product postProduct(Product product) {
    // return productRepo.save(product);
    // }

    @Override
    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }

    // public Product getProductById(Long id) {
    // return productRepo.findById(id).orElse(null);
    // }

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    // public List<Product> getAllProducts() {
    // return productRepo.findAll();
    // }

    
    public Product updateProduct(Product product) {
        return productRepository.save(product);
    }                                                   // this method is not exist in BaseService

    // public Product updateProduct(Product product) {
    // return productRepo.save(product);
    // }

    @Override
    public void deleteById(Long id) {
        productRepository.deleteById(id);
    }

    // public void deleteProduct(Long id) {
    // productRepo.deleteById(id);
    // }

}

// From my Crud project{Initial}
// package com.idb.initial.service;

// import java.util.List;
// import org.springframework.stereotype.Service;

// import com.idb.initial.entity.Product;
// import com.idb.initial.repository.ProductRepo;

// import lombok.RequiredArgsConstructor;

// @Service
// @RequiredArgsConstructor
// public class ProductService {

// private final ProductRepo productRepo;

// public Product postProduct(Product product) {
// return productRepo.save(product);
// }

// public List<Product> getAllProducts() {
// return productRepo.findAll();
// }

// public Product getProductById(Long id) {
// return productRepo.findById(id).orElse(null);
// }

// public Product updateProduct(Product product) {
// return productRepo.save(product);
// }

// public void deleteProduct(Long id) {
// productRepo.deleteById(id);
// }
// }
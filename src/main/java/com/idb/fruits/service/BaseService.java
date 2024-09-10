package com.idb.fruits.service;

import java.util.List;
import java.util.Optional;

public interface BaseService<T, ID> {
    T save(T entity);
    List<T> findAll();
    Optional<T> findById(ID id);
    // T update(T entity);
    void deleteById(ID id);
}

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

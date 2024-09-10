package com.idb.fruits.service.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idb.fruits.model.Shipment;
import com.idb.fruits.repository.ShipmentRepository;
import com.idb.fruits.service.ShipmentService;

@Service
public class ShipmentServiceImpl implements ShipmentService {
    @Autowired
    private ShipmentRepository shipmentRepository;

    @Override
    public Shipment save(Shipment shipment) {
        return shipmentRepository.save(shipment);
    }

    // public Product postProduct(Product product) {
// return productRepo.save(product);
// }

    @Override
    public Optional<Shipment> findById(Long id) {
        return shipmentRepository.findById(id);
    }

    // public List<Product> getAllProducts() {
// return productRepo.findAll();
// }

    @Override
    public List<Shipment> findAll() {
        return shipmentRepository.findAll();
    }

    // public List<Product> getAllProducts() {
// return productRepo.findAll();
// }

// public Product updateProduct(Product product) {
// return productRepo.save(product);
// }

    @Override
    public void deleteById(Long id) {
        shipmentRepository.deleteById(id);
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
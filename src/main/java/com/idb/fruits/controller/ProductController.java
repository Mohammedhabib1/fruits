package com.idb.fruits.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.idb.fruits.model.Product;
import com.idb.fruits.service.ProductService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor

public class ProductController {

    private final ProductService productService;

    @PostMapping("/product")

    public ResponseEntity<Product> createProduct(@RequestBody Product product) {
        // Product savedProduct = productService.save(product);
        // return ResponseEntity.ok(savedProduct);
        return ResponseEntity.ok(productService.save(product));

    }
    // @PostMapping("/product")
    // public Product postProduct(@RequestBody Product product) {
    // return productService.postProduct(product);
    // }

    @GetMapping("/product/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id) {
        Optional<Product> product = productService.findById(id);
        // return product.map(ResponseEntity::ok)
        // .orElseGet(() -> ResponseEntity.notFound().build());
        if (product == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(product.get());
        }
    }
    // @GetMapping("/product/{id}")
    // public ResponseEntity<Product> getProductById(@PathVariable Long id) {
    // Product product = productService.getProductById(id);
    // if (product == null) {
    // return ResponseEntity.notFound().build();
    // } else {
    // return ResponseEntity.ok(product);
    // }
    // }

    @GetMapping("/products")
    public ResponseEntity<List<Product>> getAllProducts() {
        List<Product> products = productService.findAll();
        return ResponseEntity.ok(products);
    }
    // @GetMapping("/products")
    // private List<Product> getAllProducts() {
    // return productService.getAllProducts();
    // }

    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable Long id, @RequestBody Product product) {
        Product existingProduct = productService.findById(id).orElse(null);
        if (existingProduct == null) {
            return ResponseEntity.notFound().build();
        } else {
            existingProduct.setName(product.getName());
            existingProduct.setUnit(product.getUnit());
            existingProduct.setPrice(product.getPrice());
            existingProduct.setDescription(product.getDescription());
            existingProduct.setQuantity(product.getQuantity());
            existingProduct.setImage(product.getImage());
            Product updatedProduct = productService.save(existingProduct);
            return ResponseEntity.ok(updatedProduct);
        }
    }

    // @PutMapping("/product/{id}")
    // public ResponseEntity<Product> updateProduct(@PathVariable Long id,
    // @RequestBody Product product) {
    // Product existingProduct = productService.getProductById(id);
    // if (existingProduct == null) {
    // return ResponseEntity.notFound().build();
    // } else {
    // existingProduct.setName(product.getName());
    // existingProduct.setUnit(product.getUnit());
    // existingProduct.setPrice(product.getPrice());
    // existingProduct.setDescription(product.getDescription());
    // existingProduct.setQuantity(product.getQuantity());
    // existingProduct.setImage(product.getImage());
    // Product updatedProduct = productService.updateProduct(existingProduct);
    // return ResponseEntity.ok(updatedProduct);
    // }

    // }

    @DeleteMapping("/product/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        productService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
    // @DeleteMapping("/product/{id}")
    // public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
    // productService.deleteProduct(id);
    // return ResponseEntity.noContent().build();
    // }

}

// package com.idb.initial.controller;

// import java.util.List;

// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.CrossOrigin;
// import org.springframework.web.bind.annotation.DeleteMapping;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.PutMapping;
// import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RestController;

// import com.idb.initial.entity.Product;
// import com.idb.initial.service.ProductService;

// import lombok.RequiredArgsConstructor;

// @RestController
// @RequestMapping("/api")
// @RequiredArgsConstructor
// @CrossOrigin("*")
// public class ProductController {

// private final ProductService productService;

// @PostMapping("/product")
// public Product postProduct(@RequestBody Product product) {
// return productService.postProduct(product);
// }

// @GetMapping("/products")
// private List<Product> getAllProducts() {
// return productService.getAllProducts();
// }

// @GetMapping("/product/{id}")
// public ResponseEntity<Product> getProductById(@PathVariable Long id) {
// Product product = productService.getProductById(id);
// if (product == null) {
// return ResponseEntity.notFound().build();
// } else {
// return ResponseEntity.ok(product);
// }
// }

// @PutMapping("/product/{id}")
// public ResponseEntity<Product> updateProduct(@PathVariable Long id,
// @RequestBody Product product) {
// Product existingProduct = productService.getProductById(id);
// if (existingProduct == null) {
// return ResponseEntity.notFound().build();
// } else {
// existingProduct.setName(product.getName());
// existingProduct.setUnit(product.getUnit());
// existingProduct.setPrice(product.getPrice());
// existingProduct.setDescription(product.getDescription());
// existingProduct.setQuantity(product.getQuantity());
// existingProduct.setImage(product.getImage());
// Product updatedProduct = productService.updateProduct(existingProduct);
// return ResponseEntity.ok(updatedProduct);

// }

// }

// @DeleteMapping("/product/{id}")
// public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
// productService.deleteProduct(id);
// return ResponseEntity.noContent().build();
// }

// }

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

import com.idb.fruits.model.Payment;
import com.idb.fruits.service.PaymentService;

@RestController
@RequestMapping("/api/payments")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @GetMapping
    public List<Payment> getAllPayments() {
        return paymentService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Payment> getPaymentById(@PathVariable Long id) {
        Optional<Payment> payment = paymentService.findById(id);
        return payment.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Payment createPayment(@RequestBody Payment payment) {
        return paymentService.save(payment);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Payment> updatePayment(@PathVariable Long id, @RequestBody Payment payment) {
        if (!paymentService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        payment.setId(id);
        return ResponseEntity.ok(paymentService.save(payment));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePayment(@PathVariable Long id) {
        if (!paymentService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        paymentService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}

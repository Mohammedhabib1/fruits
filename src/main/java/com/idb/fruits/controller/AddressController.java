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

import com.idb.fruits.model.Address;
import com.idb.fruits.service.AddressService;

@RestController
@RequestMapping("/api/addresses")
public class AddressController {

    @Autowired
    private AddressService addressService;

    @GetMapping
    public List<Address> getAllAddresses() {
        return addressService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Address> getAddressById(@PathVariable Long id) {
        Optional<Address> address = addressService.findById(id);
        return address.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Address createAddress(@RequestBody Address address) {
        return addressService.save(address);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Address> updateAddress(@PathVariable Long id, @RequestBody Address address) {
        if (!addressService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        address.setId(id);
        return ResponseEntity.ok(addressService.save(address));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAddress(@PathVariable Long id) {
        if (!addressService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        addressService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}

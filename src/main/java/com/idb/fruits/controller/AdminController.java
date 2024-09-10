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

import com.idb.fruits.model.Admin;
import com.idb.fruits.service.AdminService;

@RestController
@RequestMapping("/api/admins")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @GetMapping
    public List<Admin> getAllAdmins() {
        return adminService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Admin> getAdminById(@PathVariable Long id) {
        Optional<Admin> admin = adminService.findById(id);
        return admin.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Admin createAdmin(@RequestBody Admin admin) {
        return adminService.save(admin);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Admin> updateAdmin(@PathVariable Long id, @RequestBody Admin admin) {
        if (!adminService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        admin.setId(id);
        return ResponseEntity.ok(adminService.save(admin));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAdmin(@PathVariable Long id) {
        if (!adminService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        adminService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}

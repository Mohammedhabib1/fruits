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

import com.idb.fruits.model.Contact;
import com.idb.fruits.service.ContactService;

@RestController
@RequestMapping("/api/contacts")
public class ContactController {

    @Autowired
    private ContactService contactService;

    @GetMapping
    public List<Contact> getAllContacts() {
        return contactService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Contact> getContactById(@PathVariable Long id) {
        Optional<Contact> contact = contactService.findById(id);
        return contact.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Contact createContact(@RequestBody Contact contact) {
        return contactService.save(contact);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Contact> updateContact(@PathVariable Long id, @RequestBody Contact contact) {
        if (!contactService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        contact.setId(id);
        return ResponseEntity.ok(contactService.save(contact));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteContact(@PathVariable Long id) {
        if (!contactService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        contactService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}

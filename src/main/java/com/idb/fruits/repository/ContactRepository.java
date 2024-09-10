package com.idb.fruits.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.idb.fruits.model.Contact;

public interface ContactRepository extends JpaRepository<Contact, Long> {
}


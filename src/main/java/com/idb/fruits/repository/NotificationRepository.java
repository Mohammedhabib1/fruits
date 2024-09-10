package com.idb.fruits.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.idb.fruits.model.Notification;

public interface NotificationRepository extends JpaRepository<Notification, Long> {
}

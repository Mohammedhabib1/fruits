package com.idb.fruits.model;



import jakarta.persistence.*;
import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Notification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "message")
    private String message;
    @Column(name = "date")
    private Date date;
    @Column(name = "is_read")
    private boolean isRead;

    @ManyToOne
    private User user;

    // Getters and Setters
}


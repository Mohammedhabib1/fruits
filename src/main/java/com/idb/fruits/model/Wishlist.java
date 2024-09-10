package com.idb.fruits.model;



import jakarta.persistence.*;
import java.util.List;


import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Wishlist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany
    private List<Product> products;

    // Getters and Setters
}

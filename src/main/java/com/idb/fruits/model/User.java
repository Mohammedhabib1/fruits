package com.idb.fruits.model;



import jakarta.persistence.*;
    import java.util.Set;
    
   
    import lombok.Getter;
    import lombok.Setter;
    
    @Entity
    @Getter
    @Setter
    public class User {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Column(name = "username")
        private String username;

        @Column(name = "email")
        private String email;

        @Column(name = "password")
        private String password;
    
        @OneToMany(mappedBy = "user")
        private Set<Order> orders;
    
        @OneToOne(mappedBy = "user")
        private Cart cart;
    
        // Getters and Setters
    }
    
package com.idb.fruits.model;



import jakarta.persistence.*;
import java.util.Date;
import java.util.Set;


import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "orders") // 'Order' is a reserved keyword in SQL
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "date")
    private Date date;

    @Column(name = "status")
    private String status;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "order")
    private Set<OrderItem> orderItems;

    // Getters and Setters
}

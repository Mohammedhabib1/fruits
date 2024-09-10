package com.idb.fruits.model;



import jakarta.persistence.*;
import java.util.Date;


import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "payment_date")
    private Date paymentDate;

    @Column(name = "amount")
    private double amount;

    @Column(name = "method")
    private String method;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

    // Getters and Setters
}

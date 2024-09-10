package com.idb.fruits.model;



import jakarta.persistence.*;
import java.util.Date;


import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Shipment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "tracking_number")
    private String trackingNumber;


    @Column(name = "shipment_date")
    private Date shipmentDate;


    @Column(name = "carrier")
    private String carrier;

    @OneToOne
    @JoinColumn(name = "order_id")
    private Order order;

    // Getters and Setters
}

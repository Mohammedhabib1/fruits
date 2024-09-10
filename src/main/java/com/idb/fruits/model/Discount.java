package com.idb.fruits.model;



import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Discount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "code")
    private String code;

    @Column(name = "percentage")
    private BigDecimal percentage;

    @Column(name = "start_date")
    private Date startDate;

    @Column(name = "end_date")
    private Date endDate;

    // Getters and Setters
}

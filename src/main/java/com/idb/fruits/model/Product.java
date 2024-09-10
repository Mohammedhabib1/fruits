package com.idb.fruits.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "product_name")
    private String name;

    @Column(name = "unit")
    private String unit;

    @Column(name = "price")
    private Double price;

    @Column(name = "description")
    private String description;

    @Column(name = "quantity")
    private Integer quantity;

    @Column(name = "image")
    private String image;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category; 
}




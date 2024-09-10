package com.idb.fruits.model;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name")
    private String firstname;

    @Column(name = "last_name")
    private String lastname;

    @Column(name = "email")
    private String email;

    @Column(name = "phone")
    private String phone;

    @Column(name = "address")
    private String address;

    @Column(name = "city")
    private String city;

    @Column(name = "state")
    private String state;
    
    @Column(name = "postal_code")
    private String postalCode;

    @Column(name = "country")
    private String country;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;
    


}







  
    
   


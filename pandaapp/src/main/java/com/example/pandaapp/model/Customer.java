package com.example.pandaapp.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private long id;

    @Column(name = "customer_name")
    private String name;

    @Column(name = "customer_email")
    private int email;

    @Column(name = "customer_phone")
    private String phoneNumber;

    @Column(name = "customer_age")
    private short age;

    @OneToMany
    @JoinColumn(name = "food_id")
    private List<Food> foodOrderList;
}

package com.example.pandaapp.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Food {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "food_id")
    private long id;

    @Column(name = "food_name")
    private String name;

    @Column(name = "food_price")
    private int price;

    @Column(name = "quantity")
    private int quantity;
}

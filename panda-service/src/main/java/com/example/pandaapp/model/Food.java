package com.example.pandaapp.model;

import lombok.Data;
import reactor.util.annotation.Nullable;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Data
public class Food {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "food_id")
    @Nullable
    private long id;

    @Column(name = "food_name")
    private String name;

    @Column(name = "food_price")
    @Size(min = 1, message = "Food Price must be greater than 0")
    @NotNull
    private int price;

    @Column(name = "quantity")
    @NotNull
    private int quantity;
}

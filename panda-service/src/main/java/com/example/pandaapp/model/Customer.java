package com.example.pandaapp.model;

import lombok.Data;
import reactor.util.annotation.Nullable;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Data
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    @Nullable
    private long id;

    @Column(name = "customer_name")
    @NotBlank
    private String name;

    @Column(name = "customer_email")
    @NotBlank
    private int email;

    @Column(name = "customer_phone")
    private String phoneNumber;

    @Column(name = "customer_age")
    @NotBlank
    @Size(min = 1, message = "Age must be greater than 0")
    private short age;

    @ManyToOne(targetEntity = Food.class)
    private Food food;
}

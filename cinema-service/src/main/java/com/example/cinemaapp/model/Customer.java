package com.example.cinemaapp.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name="customers")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private long id;

    @Column(name = "customer_name")
    private String name;

    @Column(name = "customer_email")
    private int email;

    @Column(name = "customer_phone_number")
    private String phoneNumber;

    @Column(name = "customer_age")
    private short age;

    @ManyToOne(targetEntity = Movie.class)
    private Movie movies;
}

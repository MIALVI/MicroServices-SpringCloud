package com.example.cinemaapp.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name="booking_details")
public class BookingDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "booking_id")
    private Long id;

    @Column(name = "quantity")
    private Integer quantity;

    @ManyToOne(targetEntity = Movie.class)
    @JoinColumn
    private Movie movies;

    @OneToOne(targetEntity = Customer.class)
    @JoinColumn
    private Customer customers;
}

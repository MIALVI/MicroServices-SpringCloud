package com.example.centerapp.modal;

import lombok.*;

import javax.persistence.*;

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

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "movie_id")
    private Movie movie;

    @JoinColumn(name = "customer_id")
    @ManyToOne
    private Customer customer;
}

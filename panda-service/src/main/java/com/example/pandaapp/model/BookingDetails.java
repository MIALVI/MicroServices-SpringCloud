package com.example.pandaapp.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "booking_details")
public class BookingDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_detail_id")
    private Long id;

    @Column(name = "quantity")
    private Integer quantity;

    @ManyToOne(targetEntity = Food.class)
    @JoinColumn
    private Food food;

    @OneToOne(targetEntity = Customer.class)
    @JoinColumn
    private Customer customers;
}

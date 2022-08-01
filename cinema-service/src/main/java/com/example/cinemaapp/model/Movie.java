package com.example.cinemaapp.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name="movies")
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "movie_id")
    private long id;

    private String name;

    private int ratings;

}

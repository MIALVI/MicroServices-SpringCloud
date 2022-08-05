package com.example.cinemaapp.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Data
@Table(name="movies")
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "movie_id")
    private long id;

    @Column(name = "movie_name")
    private String name;

    @Column(name = "movie_ratings")
    private int ratings;
}

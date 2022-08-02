package com.example.cinemaapp.model;

import lombok.*;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name="movies")
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "movie_id")
    @NonNull
    private long id;

    @Column(name = "movie_name")
    private String name;

    @Column(name = "movie_ratings")
    private int ratings;
}

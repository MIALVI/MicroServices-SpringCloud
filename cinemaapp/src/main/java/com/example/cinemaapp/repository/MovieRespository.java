package com.example.cinemaapp.repository;

import com.example.cinemaapp.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRespository extends JpaRepository<Movie,Long> {
}

package com.example.cinemaapp.service;

import com.example.cinemaapp.dto.BookingDetailsDTO;
import com.example.cinemaapp.dto.CustomerDTO;
import com.example.cinemaapp.dto.MovieDTO;
import com.example.cinemaapp.model.Movie;

import java.util.List;

public interface CinemaService {

    Movie addMovie(MovieDTO movieDTO);

    BookingDetailsDTO bookMovie(int quantity, CustomerDTO customerDTO, MovieDTO movieDTO);

    boolean cancelMovie(long id, long movieId);

    List<MovieDTO> bookMovies(long id, List<MovieDTO> movieDTOList);

    MovieDTO findMovie(long id);

    List<MovieDTO> findMovies();

    List<MovieDTO> checkAllMovies();
}

package com.example.userapp.controller;

import com.example.userapp.dto.BookingDetailsDTO;
import com.example.userapp.dto.CustomerDTO;
import com.example.userapp.dto.MovieDTO;
import com.example.userapp.feign.CinemaClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api/cinema")
public class MovieController {

    @Autowired
    private CinemaClient cinemaClient;

    @GetMapping(value = "/movies")
    private ResponseEntity<List<MovieDTO>> returnMovieList(){
        return ResponseEntity.of(Optional.of(cinemaClient.findMovies()));
    }

    @GetMapping(value = "/movie/{id}")
    private ResponseEntity<MovieDTO> getMovie(@PathVariable(name = "id") long id){
        return ResponseEntity.ok(cinemaClient.findMovie(id));
    }

    @PutMapping(value = "/cancel")
    private ResponseEntity<MovieDTO> cancelBooking(@RequestBody long id){
        return ResponseEntity.ok(cinemaClient.findMovie(id));
    }

//    @PutMapping(value = "/movies/book")
//    private ResponseEntity<List<MovieDTO>> bookMovies(@RequestBody long id,List<MovieDTO> movieDTOList){
////        return ResponseEntity.ok(cinemaClient.bookMovies(id,movieDTOList));
//    }

    @PostMapping(value = "/movie/insert")
    private ResponseEntity<MovieDTO> addMovie(@RequestBody MovieDTO movieDTO){
        return ResponseEntity.ok(cinemaClient.addMovie(movieDTO));
    }

    @PostMapping(value = "/movie/book")
    private ResponseEntity<BookingDetailsDTO> bookMovie(@RequestBody int quantity, CustomerDTO customerDTO, MovieDTO movieDTO){
        return ResponseEntity.ok(cinemaClient.bookMovie(quantity, customerDTO, movieDTO));
    }
}

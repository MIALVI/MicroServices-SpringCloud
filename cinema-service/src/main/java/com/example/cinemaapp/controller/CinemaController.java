package com.example.cinemaapp.controller;

import com.example.cinemaapp.dto.BookingDetailsDTO;
import com.example.cinemaapp.dto.CustomerDTO;
import com.example.cinemaapp.dto.MovieDTO;
import com.example.cinemaapp.mapper.BookingDetailsMapper;
import com.example.cinemaapp.mapper.CustomerMapper;
import com.example.cinemaapp.mapper.MovieMapper;
import com.example.cinemaapp.service.CinemaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/cinema")
public class CinemaController {

    @Autowired
    private CinemaService cinemaService;

    @Autowired
    private BookingDetailsMapper bookingDetailsMapper;

    @Autowired
    private CustomerMapper customerMapper;

    @Autowired
    private MovieMapper movieMapper;

    @GetMapping(value = "/test")
    private ResponseEntity<String> testingHelloWorld() {
        return ResponseEntity.ok("Cinema Service World");
    }

    @GetMapping(value = "/movies")
    private ResponseEntity<List<MovieDTO>> returnMovieList() {
        return ResponseEntity.ok(cinemaService.findMovies());
    }

    @GetMapping(value = "/movie/{id}")
    private ResponseEntity<MovieDTO> getMovie(@PathVariable(name = "id") long id){
        return ResponseEntity.ok(cinemaService.findMovie(id));
    }

    @PutMapping(value = "/cancel")
    private ResponseEntity<MovieDTO> cancelBooking(@RequestBody long id){
        return ResponseEntity.ok(cinemaService.findMovie(id));
    }

    @PutMapping(value = "/movies/book")
    private ResponseEntity<List<MovieDTO>> bookMovies(@RequestBody long id,List<MovieDTO> movieDTOList){
        return ResponseEntity.ok(cinemaService.bookMovies(id,movieDTOList));
    }

    @PostMapping(value = "/movie/insert")
    private ResponseEntity<MovieDTO> addMovie(@RequestBody MovieDTO movieDTO){
        return ResponseEntity.ok(cinemaService.addMovie(movieDTO));
    }

    @PostMapping(value = "/movie/book")
    private ResponseEntity<BookingDetailsDTO> bookMovie(@RequestBody int quantity, CustomerDTO customerDTO, MovieDTO movieDTO){
        return ResponseEntity.ok(cinemaService.bookMovie(quantity, customerDTO, movieDTO));
    }
}

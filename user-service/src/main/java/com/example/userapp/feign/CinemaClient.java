package com.example.userapp.feign;

import com.example.userapp.dto.BookingDetailsDTO;
import com.example.userapp.dto.CustomerDTO;
import com.example.userapp.dto.MovieDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(value = "cinema-client", url = "http://localhost:8016/api/cinema", fallback = CinemaFallback.class)
public interface CinemaClient {
    @RequestMapping(method = RequestMethod.POST, value = "/movies", consumes = "application/json")
    MovieDTO addMovie(@RequestBody MovieDTO movieDTO);

    @RequestMapping(method = RequestMethod.POST, value = "/movie/book", consumes = "application/json")
    BookingDetailsDTO bookMovie(@RequestBody @RequestParam("qunatity") int quantity, @RequestParam("customerDTO") CustomerDTO customerDTO, @RequestParam("movieDTO") MovieDTO movieDTO);

    @RequestMapping(method = RequestMethod.PUT, value = "/cancel", consumes = "application/json")
    boolean cancelBooking(@RequestBody @RequestParam("id") long id, @RequestParam("movieId") long movieId);

    @RequestMapping(method = RequestMethod.GET, value = "/movie/book", consumes = "application/json")
    List<MovieDTO> bookMovies(@RequestBody @RequestParam("id") long id, @RequestParam("movieDTOList") List<MovieDTO> movieDTOList);

    @RequestMapping(method = RequestMethod.GET, value = "/movie/{id}", consumes = "application/json")
    MovieDTO findMovie(@PathVariable(name = "id") long id);

    @RequestMapping(method = RequestMethod.GET, value = "/movies", consumes = "application/json")
    List<MovieDTO> findMovies();
}

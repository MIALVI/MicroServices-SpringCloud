package com.example.userapp.feign;

import com.example.userapp.dto.BookingDetailsDTO;
import com.example.userapp.dto.CustomerDTO;
import com.example.userapp.dto.MovieDTO;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class CinemaFallback implements CinemaClient{

    @Override
    public MovieDTO addMovie(MovieDTO movieDTO) {
        return null;
    }

    @Override
    public BookingDetailsDTO bookMovie(int quantity, CustomerDTO customerDTO, MovieDTO movieDTO) {
        return null;
    }

    @Override
    public boolean cancelBooking(long id, long movieId) {
        return false;
    }


    @Override
    public List<MovieDTO> bookMovies(long id, List<MovieDTO> movieDTOList) {
        return null;
    }

    @Override
    public MovieDTO findMovie(long id) {
        return null;
    }

    @Override
    public List<MovieDTO> findMovies() {
        return null;
    }
}

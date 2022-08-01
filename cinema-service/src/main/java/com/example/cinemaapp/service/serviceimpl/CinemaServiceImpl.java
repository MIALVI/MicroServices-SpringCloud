package com.example.cinemaapp.service.serviceimpl;

import com.example.cinemaapp.dto.BookingDetailsDTO;
import com.example.cinemaapp.dto.CustomerDTO;
import com.example.cinemaapp.dto.MovieDTO;
import com.example.cinemaapp.exception.CustomerNotFound;
import com.example.cinemaapp.exception.MovieNotFound;
import com.example.cinemaapp.mapper.BookingDetailsMapper;
import com.example.cinemaapp.mapper.CustomerMapper;
import com.example.cinemaapp.mapper.MovieMapper;
import com.example.cinemaapp.model.BookingDetails;
import com.example.cinemaapp.model.Customer;
import com.example.cinemaapp.model.Movie;
import com.example.cinemaapp.repository.BookingDetailsRepository;
import com.example.cinemaapp.repository.CustomerRepository;
import com.example.cinemaapp.repository.MovieRespository;
import com.example.cinemaapp.service.CinemaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CinemaServiceImpl implements CinemaService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private BookingDetailsRepository bookingDetailsRepository;

    @Autowired
    private BookingDetailsMapper bookingDetailsMapper;

    @Autowired
    private MovieRespository movieRespository;

    @Autowired
    private CustomerMapper customerMapper;

    @Autowired
    private MovieMapper movieMapper;

    @Override
    public Movie addMovie(MovieDTO movieDTO) {
        return movieRespository.save(movieMapper.dtoToEntity(movieDTO));
    }

    @Override
    public BookingDetailsDTO bookMovie(int quantity, CustomerDTO customerDTO, MovieDTO movieDTO) {
        BookingDetails bookingDetails = new BookingDetails();
        bookingDetails.setQuantity(quantity);
        bookingDetails.setCustomer(customerMapper.dtoToEntity(customerDTO));
        bookingDetails.setMovie(movieMapper.dtoToEntity(movieDTO));
        return bookingDetailsMapper.entityToDto(bookingDetailsRepository.save(bookingDetails));
    }

    @Override
    public boolean cancelMovie(long id, long movieId) {
        Customer customer = customerRepository.findById(id).orElseThrow(() -> new MovieNotFound(404, "Not Found", "Movie not exist"));
        if (customer.equals(null)) {
            return false;
        } else {
            customer.getMovies().stream().filter(movie -> movie.getId() != movieId).toList();
            customerRepository.save(customer);
        }
        return true;
    }

    @Override
    public List<MovieDTO> bookMovies(long id, List<MovieDTO> movies) {
        BookingDetails bookingDetails = new BookingDetails();
        Customer customer = customerMapper.entityToDto(customerRepository.findById(id).orElseThrow(() -> new MovieNotFound(404, "Not Found", "Movie not exist")));
        if (customer.equals(null)) {
            throw new CustomerNotFound(404, "NOT_FOUND", "The Customer you are trying to Search doesn't exist.");
        }
        movies.stream().forEach(movie -> {
            bookingDetails.setQuantity(movies.size());
            bookingDetails.setCustomer(customerMapper.entityToDto(customer));
            bookingDetails.setMovie(movieMapper.dtoToEntity(movie));
            bookingDetailsRepository.save(bookingDetails);
        });
        return movies;

    }

    @Override
    public MovieDTO findMovie(long id) {
        return movieMapper.entityToDto(movieRespository.findById(id).orElseThrow(() -> new MovieNotFound(404, "Not Found", "Movie not exist")));
    }

    @Override
    public List<MovieDTO> findMovies() {
        return movieMapper.entityListToDtoList(movieRespository.findAll());
    }

    @Override
    public List<MovieDTO> checkAllMovies() {
        return movieMapper.entityListToDtoList(movieRespository.findAll());
    }
}

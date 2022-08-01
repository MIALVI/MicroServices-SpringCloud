package com.example.cinemaapp.mapper;

import com.example.cinemaapp.dto.MovieDTO;
import com.example.cinemaapp.model.Movie;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring" )
public interface MovieMapper {

    Movie dtoToEntity(MovieDTO movieDTO);

    MovieDTO entityToDto(Movie movie);

    List<MovieDTO> entityListToDtoList(List<Movie> movies);
}

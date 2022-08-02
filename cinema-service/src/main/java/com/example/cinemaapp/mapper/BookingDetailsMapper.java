package com.example.cinemaapp.mapper;

import com.example.cinemaapp.dto.BookingDetailsDTO;
import com.example.cinemaapp.model.BookingDetails;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring" )
public interface BookingDetailsMapper {

    BookingDetails dtoToEntity(BookingDetailsDTO bookingDetailsDTO);

    BookingDetailsDTO entityToDto(BookingDetails bookingDetails);
}
package com.example.pandaapp.mapper;

import com.example.pandaapp.dto.BookingDetailsDTO;
import com.example.pandaapp.model.BookingDetails;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring" )
public interface BookingDetailsMapper {

    BookingDetails dtoToEntity(BookingDetailsDTO bookingDetailsDTO);

    BookingDetailsDTO entityToDto(BookingDetails bookingDetails);

    List<BookingDetailsDTO> entityListToDtoList(List<BookingDetails> bookingDetailsList);

    List<BookingDetails> dtoListToEntityList(List<BookingDetailsDTO> bookingDetailsDTOList);
}
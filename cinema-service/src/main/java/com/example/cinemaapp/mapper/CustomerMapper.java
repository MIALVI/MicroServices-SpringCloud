package com.example.cinemaapp.mapper;

import com.example.cinemaapp.dto.CustomerDTO;
import com.example.cinemaapp.model.Customer;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring" )
public interface CustomerMapper {

    Customer dtoToEntity(CustomerDTO customerDTO);

    Customer entityToDto(Customer customer);

}

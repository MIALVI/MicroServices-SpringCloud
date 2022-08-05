package com.example.cinemaapp.mapper;

import com.example.cinemaapp.dto.CustomerDTO;
import com.example.cinemaapp.model.Customer;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring" )
public interface CustomerMapper {

    Customer dtoToEntity(CustomerDTO customerDTO);

    Customer entityToDto(Customer customer);

    List<CustomerDTO> listToDto(List<Customer> customers);

}

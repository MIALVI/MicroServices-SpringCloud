package com.example.pandaapp.mapper;

import com.example.pandaapp.dto.CustomerDTO;
import com.example.pandaapp.model.Customer;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring" )
public interface CustomerMapper {

    Customer dtoToEntity(CustomerDTO customerDTO);

    CustomerDTO entityToDto(Customer customer);

    List<CustomerDTO> entityListToDtoList(List<Customer> customerList);

    List<Customer> dtoListToEntityList(List<CustomerDTO> customerDTOSList);
}
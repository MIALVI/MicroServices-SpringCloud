package com.example.userapp.dto;

import lombok.Data;

@Data
public class BookingDetailsDTO {

    private Long id;

    private Integer quantity;

    private MovieDTO movie;

}

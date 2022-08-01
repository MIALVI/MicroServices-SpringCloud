package com.example.cinemaapp.dto;

import lombok.Data;

@Data
public class BookingDetailsDTO {

    private Long id;

    private Integer quantity;

    private MovieDTO movie;

}

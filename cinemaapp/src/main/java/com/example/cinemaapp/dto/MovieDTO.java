package com.example.cinemaapp.dto;

import com.example.cinemaapp.model.Customer;
import lombok.Data;

@Data
public class MovieDTO {

    private long id;

    private String name;

    private int ratings;

}

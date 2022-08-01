package com.example.pandaapp.dto;

import lombok.Data;

@Data
public class CustomerDTO {

    private long id;
    private String name;
    private int email;
    private String phoneNumber;
    private short age;
}

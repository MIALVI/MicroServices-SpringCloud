package com.example.userapp.modal;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MovieCustomer {
    private String name;
    private long id;
    private short age;
    private String email;
    private String phoneNo;
}

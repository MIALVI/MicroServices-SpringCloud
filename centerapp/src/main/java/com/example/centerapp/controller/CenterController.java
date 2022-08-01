package com.example.centerapp.controller;

import com.example.centerapp.feign.BookingClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/center/")
public class CenterController {

    @Autowired
    private BookingClient bookingClient;

    @GetMapping("/test")
    ResponseEntity<String> testApi(){
        return bookingClient.testApi();
    }

}

package com.example.cinemaapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class CinemaappApplication {
	public static void main(String[] args) {
		SpringApplication.run(CinemaappApplication.class, args);
	}
}

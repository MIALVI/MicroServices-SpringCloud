package com.example.pandaapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class PandaappApplication {

	public static void main(String[] args) {
		SpringApplication.run(PandaappApplication.class, args);
	}
}

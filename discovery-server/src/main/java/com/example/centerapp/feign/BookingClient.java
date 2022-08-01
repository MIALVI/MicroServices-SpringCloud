package com.example.centerapp.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "cinema-api", url = "http://localhost:8081/api/cinema", fallback = Fallback.class)
public interface BookingClient {
    @GetMapping("/test")
    ResponseEntity<String> testApi();
}

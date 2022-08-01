package com.example.centerapp.feign;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class Fallback implements BookingClient {
    @Override
    public ResponseEntity<String> testApi() {
        return ResponseEntity.ok("Fallback");
    }
}

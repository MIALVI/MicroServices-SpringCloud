package com.example.userapp.controller;

import com.example.userapp.modal.Foods;
import com.example.userapp.modal.Movie;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/panda-customer/foods/")
public class PandaController {

    @GetMapping("/test")
    public ResponseEntity<String> test(){
        return ResponseEntity.ok("Hello");
    }

    @GetMapping("{foodId}")
    public ResponseEntity<Foods> findFood(@PathVariable(name = "foodId") long foodId){
        return new ResponseEntity(new Movie(), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Foods>> findAllFood(){
        return new ResponseEntity(new Foods(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Foods> orderFood(){
        return new ResponseEntity(new Foods(),HttpStatus.OK);
    }

    @DeleteMapping("/{customerId}")
    public ResponseEntity<Void> cancleOrder(){
        return new ResponseEntity(HttpStatus.ACCEPTED).noContent().build();
    }


}

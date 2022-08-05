package com.example.userapp.controller;

import com.example.userapp.feign.PandaClient;
import com.example.userapp.modal.Food;
import com.example.userapp.modal.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/panda-customer/foods/")
public class PandaController {

//    @Autowired
//    private PandaClient pandaClient;

    @GetMapping("/test")
    public ResponseEntity<String> test(){
        return ResponseEntity.ok("Hello");
    }

    @GetMapping("{foodId}")
    public ResponseEntity<Food> findFood(@PathVariable(name = "foodId") long foodId){
        return new ResponseEntity(new Movie(), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Food>> findAllFood(){
        return new ResponseEntity(new Food(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Food> orderFood(){
        return new ResponseEntity(new Food(),HttpStatus.OK);
    }

    @DeleteMapping("/{customerId}")
    public ResponseEntity<Void> cancleOrder(){
        return new ResponseEntity(HttpStatus.ACCEPTED).noContent().build();
    }


}

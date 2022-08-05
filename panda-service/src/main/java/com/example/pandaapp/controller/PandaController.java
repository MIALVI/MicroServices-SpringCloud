package com.example.pandaapp.controller;

import com.example.pandaapp.dto.CustomerDTO;
import com.example.pandaapp.dto.FoodDTO;
import com.example.pandaapp.model.Food;
import com.example.pandaapp.service.PandaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(value = "/api/panda-service")
public class PandaController {
    @Autowired
    private PandaService pandaService;

    @GetMapping(value = "/test")
    private String testingHelloWorld(){
        return "Panda Service World";
    }

    @PostMapping(value = "/add-food")
    private ResponseEntity<Food> addFood(@RequestBody Food foodDTO){
        return ResponseEntity.ok(pandaService.addFood(foodDTO));
    }

    @PutMapping(value = "/cancel-order")
    private ResponseEntity<?> cancelOrder(@RequestBody long id){
        return ResponseEntity.ok(pandaService.cancelOrder(id));
    }

    @GetMapping(value = "/find-food")
    private ResponseEntity<?> findFood(@RequestHeader long id){
        return ResponseEntity.ok(pandaService.findFood(id));
    }

    @GetMapping(value = "/get-food-category")
    private ResponseEntity<?> findCategory(@RequestHeader long id){
        return ResponseEntity.of(Optional.of(pandaService.getFoodCategory(id)));
    }

    @GetMapping(value = "/get-food")
    private ResponseEntity<?> getAllFood(){
        return ResponseEntity.of(Optional.of(pandaService.getAllFoods()));
    }

    @GetMapping(value = "/order-food")
    private ResponseEntity<?> orderFood(@RequestBody int quantity, CustomerDTO customerDTO, FoodDTO foodDTO){
        return ResponseEntity.of(Optional.of(pandaService.orderFood(quantity, customerDTO, foodDTO)));
    }
}

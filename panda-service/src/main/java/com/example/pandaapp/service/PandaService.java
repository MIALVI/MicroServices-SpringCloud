package com.example.pandaapp.service;

import com.example.pandaapp.dto.BookingDetailsDTO;
import com.example.pandaapp.dto.CustomerDTO;
import com.example.pandaapp.dto.FoodDTO;
import com.example.pandaapp.model.Category;
import com.example.pandaapp.model.Food;

import java.util.List;

public interface PandaService {

    Food addFood(Food foodDTO);

    boolean cancelOrder(long id);

    Category getFoodCategory(long id);

    List<FoodDTO> getAllFoods();

    BookingDetailsDTO orderFood(int quantity, CustomerDTO customerDTO, FoodDTO foodDTO);

    FoodDTO findFood(long id);
}

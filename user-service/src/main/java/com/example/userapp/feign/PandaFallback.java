package com.example.userapp.feign;

import com.example.userapp.dto.BookingDetailsDTO;
import com.example.userapp.dto.CategoryDTO;
import com.example.userapp.dto.CustomerDTO;
import com.example.userapp.dto.FoodDTO;
import com.example.userapp.modal.Food;

import java.util.List;

public class PandaFallback implements PandaClient{

    @Override
    public Food addFood(Food foodDTO) {
        return null;
    }

    @Override
    public boolean cancelOrder(long id) {
        return false;
    }

    @Override
    public CategoryDTO getFoodCategory(long id) {
        return null;
    }

    @Override
    public List<FoodDTO> getAllFoods() {
        return null;
    }

    @Override
    public BookingDetailsDTO orderFood(int quantity, CustomerDTO customerDTO, FoodDTO foodDTO) {
        return null;
    }

    @Override
    public FoodDTO findFood(long id) {
        return null;
    }
}

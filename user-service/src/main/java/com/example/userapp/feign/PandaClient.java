package com.example.userapp.feign;

import com.example.userapp.dto.*;
import com.example.userapp.modal.Food;
import org.springframework.cloud.openfeign.FeignClient;

import java.util.List;

@FeignClient(value = "panda-client", url = "http://localhost:8019/", fallback = PandaFallback.class)
public interface PandaClient {

    Food addFood(Food foodDTO);

    boolean cancelOrder(long id);

    CategoryDTO getFoodCategory(long id);

    List<FoodDTO> getAllFoods();

    BookingDetailsDTO orderFood(int quantity, CustomerDTO customerDTO, FoodDTO foodDTO);

    FoodDTO findFood(long id);
}

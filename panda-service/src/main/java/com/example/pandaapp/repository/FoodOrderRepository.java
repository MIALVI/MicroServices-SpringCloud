package com.example.pandaapp.repository;

import com.example.pandaapp.model.Food;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodOrderRepository extends JpaRepository<Food,Long> {
}

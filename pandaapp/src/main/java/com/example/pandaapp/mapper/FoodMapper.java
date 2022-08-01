package com.example.pandaapp.mapper;

import com.example.pandaapp.dto.FoodDTO;
import com.example.pandaapp.model.Food;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface FoodMapper {

    Food dtoToEntity(FoodDTO foodDTO);

    FoodDTO entityToDto(Food food);

    List<FoodDTO> entityListToDtoList(List<Food> foodList);

    List<Food> dtoListToEntityList(List<FoodDTO> foodDTOList);
}
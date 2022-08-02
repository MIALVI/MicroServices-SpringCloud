package com.example.pandaapp.mapper;

import com.example.pandaapp.dto.CategoryDTO;
import com.example.pandaapp.dto.CustomerDTO;
import com.example.pandaapp.model.Category;
import com.example.pandaapp.model.Customer;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring" )
public interface CategoryMapper {

    Category dtoToEntity(CategoryDTO categoryDTO);

    CategoryDTO entityToDto(Category category);

    List<CategoryDTO> entityListToDtoList(List<Category> categoryList);

    List<Category> dtoListToEntityList(List<CategoryDTO> categoryDTOList);
}
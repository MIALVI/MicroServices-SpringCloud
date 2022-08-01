package com.example.pandaapp.service.serviceimpl;

import com.example.pandaapp.dto.BookingDetailsDTO;
import com.example.pandaapp.dto.CustomerDTO;
import com.example.pandaapp.dto.FoodDTO;
import com.example.pandaapp.exception.CustomerNotFound;
import com.example.pandaapp.exception.FoodNotFound;
import com.example.pandaapp.mapper.BookingDetailsMapper;
import com.example.pandaapp.mapper.CategoryMapper;
import com.example.pandaapp.mapper.CustomerMapper;
import com.example.pandaapp.mapper.FoodMapper;
import com.example.pandaapp.model.BookingDetails;
import com.example.pandaapp.model.Category;
import com.example.pandaapp.model.Customer;
import com.example.pandaapp.repository.BookingDetailsRepository;
import com.example.pandaapp.repository.CategoryRepository;
import com.example.pandaapp.repository.CustomerRepository;
import com.example.pandaapp.repository.FoodOrderRepository;
import com.example.pandaapp.service.PandaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PandaServiceImpl implements PandaService {

    @Autowired
    private FoodOrderRepository foodOrderRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private BookingDetailsRepository bookingDetailsRepository;

    @Autowired
    private BookingDetailsMapper bookingDetailsMapper;

    @Autowired
    private CategoryMapper categoryMapper;

    @Autowired
    private CustomerMapper customerMapper;

    @Autowired
    private FoodMapper foodMapper;

    @Override
    public FoodDTO addFood(FoodDTO foodDTO) {
        return foodMapper.entityToDto(foodOrderRepository.save(foodMapper.dtoToEntity(foodDTO)));
    }

    @Override
    public boolean cancelOrder(long id) {
        Customer customer = customerRepository.findById(id).orElseThrow(() -> new CustomerNotFound(404, "Not Found", "Customer not exist"));
        if (customer.equals(null)) {
            return false;
        } else {
            customer.getFoodOrderList().stream().filter(food -> food.getId() != id).toList();
            customerRepository.save(customer);
        }
        return true;
    }

    @Override
    public Category getFoodCategory(long id) {
        return categoryRepository.findById(id).orElseThrow(() -> new FoodNotFound(404, HttpStatus.NOT_FOUND.getReasonPhrase(), "The food is not found in the category."));
    }

    @Override
    public List<FoodDTO> getAllFoods() {
        return foodMapper.entityListToDtoList(foodOrderRepository.findAll());
    }

    @Override
    public BookingDetailsDTO orderFood(int quantity, CustomerDTO customerDTO, FoodDTO foodDTO) {
        BookingDetails bookingDetails = new BookingDetails();
        bookingDetails.setQuantity(quantity);
        bookingDetails.setCustomer(customerMapper.dtoToEntity(customerDTO));
        bookingDetails.setFoodOrder(foodMapper.dtoToEntity(foodDTO));
        return bookingDetailsMapper.entityToDto(bookingDetailsRepository.save(bookingDetails));
    }

    @Override
    public FoodDTO findFood(long id) {
        return foodMapper.entityToDto(foodOrderRepository.findById(id).orElseThrow(() -> new FoodNotFound(404, HttpStatus.NOT_FOUND.getReasonPhrase(), "The food is not found in the category.")));
    }
}

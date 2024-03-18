package com.kirsing.ordermicroservice.service;

import com.kirsing.ordermicroservice.dto.OrderDTO;
import com.kirsing.ordermicroservice.dto.OrderDTOFromFE;
import com.kirsing.ordermicroservice.dto.UserDTO;
import com.kirsing.ordermicroservice.entity.Order;
import com.kirsing.ordermicroservice.mapper.OrderMapper;
import com.kirsing.ordermicroservice.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OrderService {

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    SequenceGenerator sequenceGenerator;

    @Autowired
    RestTemplate restTemplate;



    public OrderDTO saveOrderInDb(OrderDTOFromFE orderDetails) {
        Integer newOrderID = sequenceGenerator.generateNextOrderId();
        UserDTO userDTO = fetchUserDetailsFromUserId(orderDetails.getUserId());
        Order orderToBeSaved = new Order(newOrderID, orderDetails.getFoodItemsList(), orderDetails.getRestaurant(), userDTO);
        orderRepository.save(orderToBeSaved);
        return OrderMapper.mapToOrderDto(orderToBeSaved, new OrderDTO());
    }

    private UserDTO fetchUserDetailsFromUserId(Integer userId) {
        return restTemplate.getForObject("http://USER-SERVICE/user/fetchUserById/" + userId, UserDTO.class);
    }
}

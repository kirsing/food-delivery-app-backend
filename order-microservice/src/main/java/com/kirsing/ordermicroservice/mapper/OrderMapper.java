package com.kirsing.ordermicroservice.mapper;

import com.kirsing.ordermicroservice.dto.OrderDTO;
import com.kirsing.ordermicroservice.entity.Order;

public class OrderMapper {
    public static OrderDTO mapToOrderDto(Order order, OrderDTO orderDTO) {
        orderDTO.setUserDTO(order.getUserDTO());
        orderDTO.setRestaurant(order.getRestaurant());
        orderDTO.setOrderId(order.getOrderId());
        orderDTO.setFoodItemsList(order.getFoodItemsList());
        return orderDTO;
    }

    public static Order mapToOrder(OrderDTO orderDTO, Order order) {
        order.setUserDTO(orderDTO.getUserDTO());
        order.setRestaurant(orderDTO.getRestaurant());
        order.setOrderId(orderDTO.getOrderId());
        order.setFoodItemsList(orderDTO.getFoodItemsList());
        return order;
    }
}

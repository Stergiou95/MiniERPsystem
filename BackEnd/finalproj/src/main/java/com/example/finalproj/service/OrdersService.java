package com.example.finalproj.service;

import com.example.finalproj.dto.OrdersDTO;
import com.example.finalproj.model.Orders;

import java.util.List;

public interface OrdersService {
    OrdersDTO createOrder(OrdersDTO ordersDTO) throws Exception;
    List<OrdersDTO> getAllOrders() throws Exception;
    OrdersDTO getOrderById(Long id) throws Exception;
    OrdersDTO updateOrder(OrdersDTO ordersDTO) throws Exception;
    void deleteOrderById(Long id) throws Exception;
}

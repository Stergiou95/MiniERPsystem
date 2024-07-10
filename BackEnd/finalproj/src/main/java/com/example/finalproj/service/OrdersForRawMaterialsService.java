package com.example.finalproj.service;

import com.example.finalproj.dto.OrdersForRawMaterialsDTO;

import java.util.List;

public interface OrdersForRawMaterialsService {
    OrdersForRawMaterialsDTO createOrder(OrdersForRawMaterialsDTO ordersDTO) throws Exception;
    List<OrdersForRawMaterialsDTO> getAllOrders() throws Exception;
    OrdersForRawMaterialsDTO getOrderById(Long id) throws Exception;
    OrdersForRawMaterialsDTO updateOrder(OrdersForRawMaterialsDTO ordersDTO) throws Exception;
    void deleteOrderById(Long id) throws Exception;
}

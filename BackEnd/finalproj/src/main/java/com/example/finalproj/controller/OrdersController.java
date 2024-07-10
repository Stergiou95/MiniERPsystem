package com.example.finalproj.controller;

import com.example.finalproj.dto.OrdersDTO;
import com.example.finalproj.service.OrdersService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
@AllArgsConstructor
@CrossOrigin(origins = "http://127.0.0.1:5500")
public class OrdersController {

    private final OrdersService ordersService;

    @GetMapping
    public List<OrdersDTO> getAllOrders() throws Exception {
        return ordersService.getAllOrders();
    }

    @GetMapping("/{id}")
    public OrdersDTO getOrderById(@PathVariable Long id) throws Exception {
        return ordersService.getOrderById(id);
    }

    @PostMapping
    public OrdersDTO createOrder(@RequestBody OrdersDTO ordersDTO) throws Exception {
        return ordersService.createOrder(ordersDTO);
    }

    @PutMapping("/{id}")
    public OrdersDTO updateOrder(@PathVariable Long id, @RequestBody OrdersDTO ordersDTO) throws Exception {
        ordersDTO.setOrderID(id);
        return ordersService.updateOrder(ordersDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteOrderById(@PathVariable Long id) throws Exception {
        ordersService.deleteOrderById(id);
    }
}

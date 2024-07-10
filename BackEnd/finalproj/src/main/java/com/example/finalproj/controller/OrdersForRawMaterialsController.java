package com.example.finalproj.controller;

import com.example.finalproj.dto.OrdersForRawMaterialsDTO;
import com.example.finalproj.service.OrdersForRawMaterialsService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rawMaterialOrders")
@AllArgsConstructor
@CrossOrigin(origins = "http://127.0.0.1:5500")
public class OrdersForRawMaterialsController {

    private final OrdersForRawMaterialsService ordersForRawMaterialsService;

    @GetMapping
    public List<OrdersForRawMaterialsDTO> getAllOrders() throws Exception {
        return ordersForRawMaterialsService.getAllOrders();
    }

    @GetMapping("/{id}")
    public OrdersForRawMaterialsDTO getOrderById(@PathVariable Long id) throws Exception {
        return ordersForRawMaterialsService.getOrderById(id);
    }

    @PostMapping
    public OrdersForRawMaterialsDTO createOrder(@RequestBody OrdersForRawMaterialsDTO ordersDTO) throws Exception {
        return ordersForRawMaterialsService.createOrder(ordersDTO);
    }

    @PutMapping("/{id}")
    public OrdersForRawMaterialsDTO updateOrder(@PathVariable Long id, @RequestBody OrdersForRawMaterialsDTO ordersDTO) throws Exception {
        ordersDTO.setRmorderID(id);
        return ordersForRawMaterialsService.updateOrder(ordersDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteOrder(@PathVariable Long id) throws Exception {
        ordersForRawMaterialsService.deleteOrderById(id);
    }
}

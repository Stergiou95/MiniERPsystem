package com.example.finalproj.service.impl;

import com.example.finalproj.dto.OrdersDTO;
import com.example.finalproj.dto.ProductDetailsDTO;
import com.example.finalproj.mapper.OrdersMapper;
import com.example.finalproj.model.*;
import com.example.finalproj.repository.*;
import com.example.finalproj.service.OrdersService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@AllArgsConstructor
@Slf4j
public class OrdersServiceImpl implements OrdersService {

    private final OrdersRepository ordersRepository;
    private final OrdersMapper ordersMapper;
    private final ProductsOrdersRepository productsOrdersRepository;
    private final StatusesRepository statusesRepository;
    private final OutOrderStatusRepository outOrderStatusRepository;
    private final ProductsRepository productsRepository;
    private final CustomersRepository customersRepository;
    private final PartnersRepository partnersRepository;

    @Override
    public OrdersDTO createOrder(OrdersDTO ordersDTO) throws Exception {
        Orders order = ordersMapper.toEntity(ordersDTO);

        // Set customer and partner
        order.setCustomer(customersRepository.findById(ordersDTO.getCustID()).orElseThrow(() -> new RuntimeException("Customer not found")));
        order.setPartner(partnersRepository.findById(ordersDTO.getPartnerID()).orElseThrow(() -> new RuntimeException("Partner not found")));

        // Save the order
        Orders savedOrder = ordersRepository.save(order);

        // Insert into ProductsOrders
        for (ProductDetailsDTO productDetails : ordersDTO.getCart()) {
            ProductsOrdersID productsOrdersID = new ProductsOrdersID(savedOrder.getOrderID(), productDetails.getProductID());
            ProductsOrders productsOrders = new ProductsOrders(productsOrdersID, productDetails.getUnits(),
                    productsRepository.findById(productDetails.getProductID()).orElseThrow(() -> new RuntimeException("Product not found")),
                    savedOrder);
            productsOrdersRepository.save(productsOrders);
        }

        // Insert into OutOrderStatus with statusID 1
        OutOrderStatusId outOrderStatusId = new OutOrderStatusId(savedOrder.getOrderID(), 1L);
        OutOrderStatus outOrderStatus = new OutOrderStatus(outOrderStatusId, savedOrder,
                statusesRepository.findById(1L).orElseThrow(() -> new RuntimeException("Status not found")),
                LocalDateTime.now());
        outOrderStatusRepository.save(outOrderStatus);

        return ordersMapper.toDTO(savedOrder);
    }

    @Override
    public List<OrdersDTO> getAllOrders() throws Exception {
        List<Orders> ordersList = ordersRepository.findAll();
        return ordersList.stream()
                .map(ordersMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public OrdersDTO getOrderById(Long id) throws Exception {
        Orders orders = ordersRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Order not found"));
        return ordersMapper.toDTO(orders);
    }

    @Override
    public OrdersDTO updateOrder(OrdersDTO ordersDTO) throws Exception {
        Orders orders = ordersRepository.findById(ordersDTO.getOrderID())
                .orElseThrow(() -> new RuntimeException("Order not found"));

        // Ενημέρωση των πεδίων της παραγγελίας με τις τιμές από το DTO
        orders.setCustomer(customersRepository.findById(ordersDTO.getCustID()).orElseThrow(() -> new RuntimeException("Customer not found")));
        orders.setPartner(partnersRepository.findById(ordersDTO.getPartnerID()).orElseThrow(() -> new RuntimeException("Partner not found")));

        ordersRepository.save(orders);

        return ordersMapper.toDTO(orders);
    }

    @Override
    public void deleteOrderById(Long id) throws Exception {
        ordersRepository.deleteById(id);
    }
}

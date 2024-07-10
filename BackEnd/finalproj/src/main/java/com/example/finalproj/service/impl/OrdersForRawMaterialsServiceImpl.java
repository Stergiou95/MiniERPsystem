package com.example.finalproj.service.impl;

import com.example.finalproj.dto.OrdersForRawMaterialsDTO;
import com.example.finalproj.dto.RawMaterialsDetailsDTO;
import com.example.finalproj.mapper.OrdersForRawMaterialsMapper;
import com.example.finalproj.model.*;
import com.example.finalproj.repository.*;
import com.example.finalproj.service.OrdersForRawMaterialsService;
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
public class OrdersForRawMaterialsServiceImpl implements OrdersForRawMaterialsService {

    private final OrdersForRawMaterialsRepository ordersForRawMaterialsRepository;
    private final OrdersForRawMaterialsMapper ordersForRawMaterialsMapper;
    private final SuppliersRepository suppliersRepository;
    private final RawMaterialsRepository rawMaterialsRepository;
    private final RawMaterialsOrdersRawMaterialsRepository rawMaterialsOrdersRawMaterialsRepository;
    private final StatusesRepository statusesRepository;
    private final OrdersForRawMaterialsStatusRepository rawMaterialsOrderStatusRepository;

    @Override
    public OrdersForRawMaterialsDTO createOrder(OrdersForRawMaterialsDTO ordersDTO) throws Exception {
        OrdersForRawMaterials order = ordersForRawMaterialsMapper.toEntity(ordersDTO);

        // Set supplier
        order.setSupplier(suppliersRepository.findById(ordersDTO.getSupplierID()).orElseThrow(() -> new RuntimeException("Supplier not f")));

        // Save the order first to generate an ID
        OrdersForRawMaterials savedOrder = ordersForRawMaterialsRepository.save(order);

        // Insert into RawMaterialsOrdersRawMaterials
        for (RawMaterialsDetailsDTO rawMaterialsDetails : ordersDTO.getRawMaterialsDetails()) {
            RawMaterials rawMaterial = rawMaterialsRepository.findById(rawMaterialsDetails.getRawMaterialID())
                    .orElseThrow(() -> new RuntimeException("Raw Material not found"));

            RawMaterialsOrdersRawMaterialsId id = new RawMaterialsOrdersRawMaterialsId(savedOrder.getRmorderID(), rawMaterial.getRawMatID());
            RawMaterialsOrdersRawMaterials rawMaterialsOrdersRawMaterials = new RawMaterialsOrdersRawMaterials(id, rawMaterialsDetails.getUnits());
            rawMaterialsOrdersRawMaterials.setOrder(savedOrder);
            rawMaterialsOrdersRawMaterials.setRawMaterial(rawMaterial);

            rawMaterialsOrdersRawMaterialsRepository.save(rawMaterialsOrdersRawMaterials);
        }

        // Insert into RawMaterialsOrderStatus with statusID 1
        RawMaterialsOrderStatusId statusId = new RawMaterialsOrderStatusId(savedOrder.getRmorderID(), 1L);
        RawMaterialsOrderStatus rawMaterialsOrderStatus = new RawMaterialsOrderStatus(statusId, savedOrder,
                statusesRepository.findById(1L).orElseThrow(() -> new RuntimeException("Status not found")),
                LocalDateTime.now());

        rawMaterialsOrderStatusRepository.save(rawMaterialsOrderStatus);

        return ordersForRawMaterialsMapper.toDTO(savedOrder);
    }

    @Override
    public List<OrdersForRawMaterialsDTO> getAllOrders() throws Exception {
        List<OrdersForRawMaterials> ordersList = ordersForRawMaterialsRepository.findAll();
        return ordersList.stream()
                .map(ordersForRawMaterialsMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public OrdersForRawMaterialsDTO getOrderById(Long id) throws Exception {
        OrdersForRawMaterials orders = ordersForRawMaterialsRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Order not found"));
        return ordersForRawMaterialsMapper.toDTO(orders);
    }

    @Override
    public OrdersForRawMaterialsDTO updateOrder(OrdersForRawMaterialsDTO ordersDTO) throws Exception {
        OrdersForRawMaterials orders = ordersForRawMaterialsRepository.findById(ordersDTO.getRmorderID())
                .orElseThrow(() -> new RuntimeException("Order not found"));

        // Update the fields of the order with values from the DTO
        orders.setSupplier(suppliersRepository.findById(ordersDTO.getSupplierID()).orElseThrow(() -> new RuntimeException("Supplier not found")));

        OrdersForRawMaterials updatedOrder = ordersForRawMaterialsRepository.save(orders);

        return ordersForRawMaterialsMapper.toDTO(updatedOrder);
    }

    @Override
    public void deleteOrderById(Long id) throws Exception {
        ordersForRawMaterialsRepository.deleteById(id);
    }
}

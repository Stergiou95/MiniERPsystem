package com.example.finalproj.mapper;

import com.example.finalproj.dto.OutOrderStatusDTO;
import com.example.finalproj.model.OutOrderStatus;
import com.example.finalproj.repository.OrdersRepository;
import com.example.finalproj.repository.StatusesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OutOrderStatusMapper {

    @Autowired
    private OrdersRepository ordersRepository;

    @Autowired
    private StatusesRepository statusesRepository;

    public OutOrderStatusDTO toDTO(OutOrderStatus outOrderStatus) {
        return new OutOrderStatusDTO(
                outOrderStatus.getOrder().getOrderID(),
                outOrderStatus.getStatus().getStatusId(),
                outOrderStatus.getStatus().getStatusName(),
                outOrderStatus.getDateOrdersalesStatusChanged()
        );
    }

    public OutOrderStatus toEntity(OutOrderStatusDTO dto) {
        OutOrderStatus outOrderStatus = new OutOrderStatus();
        outOrderStatus.setOrder(ordersRepository.findById(dto.getOrderID()).orElse(null));
        outOrderStatus.setStatus(statusesRepository.findById(dto.getStatusID()).orElse(null));
        outOrderStatus.setDateOrdersalesStatusChanged(dto.getDateOrderSalesStatusChanged());
        return outOrderStatus;
    }
}

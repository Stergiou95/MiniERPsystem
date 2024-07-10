package com.example.finalproj.mapper;

import com.example.finalproj.dto.RawMaterialsOrderStatusDTO;
import com.example.finalproj.model.RawMaterialsOrderStatus;
import com.example.finalproj.repository.OrdersForRawMaterialsRepository;
import com.example.finalproj.repository.StatusesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RawMaterialsOrderStatusMapper {

    @Autowired
    private OrdersForRawMaterialsRepository ordersRepository;

    @Autowired
    private StatusesRepository statusesRepository;

    public RawMaterialsOrderStatusDTO toDTO(RawMaterialsOrderStatus orderStatus) {
        return new RawMaterialsOrderStatusDTO(
                orderStatus.getStatuses().getStatusId(),
                orderStatus.getStatuses().getStatusName(), // προσθήκη statusName
                orderStatus.getOrder().getRmorderID(),
                orderStatus.getDateOfStatusChange()
        );
    }

    public RawMaterialsOrderStatus toEntity(RawMaterialsOrderStatusDTO dto) {
        RawMaterialsOrderStatus orderStatus = new RawMaterialsOrderStatus();
        orderStatus.setStatuses(statusesRepository.findById(dto.getStatusID()).orElse(null));
        orderStatus.setOrder(ordersRepository.findById(dto.getRmorderID()).orElse(null));
        orderStatus.setDateOfStatusChange(dto.getDateOfStatusChange());
        return orderStatus;
    }
}

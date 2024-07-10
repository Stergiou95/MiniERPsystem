package com.example.finalproj.mapper;

import com.example.finalproj.dto.ProductionDTO;
import com.example.finalproj.model.Productions;
import com.example.finalproj.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductionMapper {

    @Autowired
    private OrdersRepository ordersRepository;

    @Autowired
    private ShiftsRepository shiftsRepository;

    @Autowired
    private QualityControlRepository qualityControlRepository;

    @Autowired
    private QCReportsRepository qcReportsRepository;

    public ProductionDTO toDTO(Productions production) {
        return new ProductionDTO(
                production.getProductionID(),
                production.getOrders().getOrderID(),
                production.getShifts().getShiftID(),
                production.getQualityControl().getRepID()

        );
    }

    public Productions toEntity(ProductionDTO dto) {
        Productions production = new Productions();
        production.setProductionID(dto.getProductionID());
        production.setOrders(ordersRepository.findById(dto.getOrderID()).orElse(null));
        production.setShifts(shiftsRepository.findById(dto.getShiftID()).orElse(null));
        production.setQualityControl(qualityControlRepository.findById(dto.getRepID()).orElse(null));
        return production;
    }
}

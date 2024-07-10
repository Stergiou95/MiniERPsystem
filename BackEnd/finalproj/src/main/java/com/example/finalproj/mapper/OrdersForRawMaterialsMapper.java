package com.example.finalproj.mapper;

import com.example.finalproj.dto.OrdersForRawMaterialsDTO;
import com.example.finalproj.dto.RawMaterialsDetailsDTO;
import com.example.finalproj.dto.RawMaterialsOrderStatusDTO;
import com.example.finalproj.model.OrdersForRawMaterials;
import com.example.finalproj.model.RawMaterialsOrdersRawMaterials;
import com.example.finalproj.model.RawMaterialsOrderStatus;
import com.example.finalproj.repository.SuppliersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class OrdersForRawMaterialsMapper {

    @Autowired
    private SuppliersRepository suppliersRepository;

    public OrdersForRawMaterialsMapper(SuppliersRepository suppliersRepository) {
        this.suppliersRepository = suppliersRepository;
    }

    public OrdersForRawMaterialsDTO toDTO(OrdersForRawMaterials order) {
        List<RawMaterialsDetailsDTO> rawMaterialsDetails = order.getRawMaterialsOrdersRawMaterials().stream()
                .map(rmOrder -> new RawMaterialsDetailsDTO(
                        rmOrder.getRawMaterial().getRawMatID(),
                        rmOrder.getRawMaterial().getRawMaterialName(),
                        rmOrder.getUnits(),
                        rmOrder.getRawMaterial().getRawMaterialsSuppliers().stream()
                                .filter(supplier -> supplier.getSuppliers().getSupplierID().equals(order.getSupplier().getSupplierID()))
                                .findFirst()
                                .map(supplier -> supplier.getCostPerUnit())
                                .orElse(0.0),
                        rmOrder.getUnits() * rmOrder.getRawMaterial().getRawMaterialsSuppliers().stream()
                                .filter(supplier -> supplier.getSuppliers().getSupplierID().equals(order.getSupplier().getSupplierID()))
                                .findFirst()
                                .map(supplier -> supplier.getCostPerUnit())
                                .orElse(0.0)
                ))
                .collect(Collectors.toList());

        double totalCost = rawMaterialsDetails.stream()
                .mapToDouble(RawMaterialsDetailsDTO::getTotalCost)
                .sum();

        List<RawMaterialsOrderStatusDTO> statusHistory = order.getRawMaterialsOrderStatuses().stream()
                .map(status -> new RawMaterialsOrderStatusDTO(
                        status.getStatuses().getStatusId(),
                        status.getStatuses().getStatusName(),
                        status.getOrder().getRmorderID(),
                        status.getDateOfStatusChange()
                ))
                .collect(Collectors.toList());

        return new OrdersForRawMaterialsDTO(
                order.getRmorderID(),
                order.getSupplier().getSupplierID(),
                order.getSupplier().getCompanyName(),
                rawMaterialsDetails,
                statusHistory.isEmpty() ? null  : statusHistory.get(0).getDateOfStatusChange(),
                totalCost,
                statusHistory.isEmpty() ? "Unknown" : statusHistory.get(0).getStatusName(),
                statusHistory
        );
    }

    public OrdersForRawMaterials toEntity(OrdersForRawMaterialsDTO dto) {
        OrdersForRawMaterials order = new OrdersForRawMaterials();
        order.setRmorderID(dto.getRmorderID());
        order.setSupplier(suppliersRepository.findById(dto.getSupplierID()).orElse(null));
        return order;
    }
}

package com.example.finalproj.mapper;

import com.example.finalproj.dto.OrdersDTO;
import com.example.finalproj.dto.OutOrderStatusDTO;
import com.example.finalproj.dto.ProductDetailsDTO;
import com.example.finalproj.model.Orders;
import com.example.finalproj.model.ProductsOrders;
import com.example.finalproj.model.OutOrderStatus;
import com.example.finalproj.repository.CustomersRepository;
import com.example.finalproj.repository.LocationsRepository;
import com.example.finalproj.repository.PartnersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class OrdersMapper {
    @Autowired
    private CustomersRepository customersRepository;
    private PartnersRepository partnersRepository;





    public OrdersMapper(CustomersRepository customersRepository, PartnersRepository partnersRepository) {
        this.customersRepository = customersRepository;
        this.partnersRepository = partnersRepository;
    }

    public OrdersDTO toDTO(Orders orders) {
        List<ProductDetailsDTO> cart = orders.getProductsOrders().stream()
                .map(po -> new ProductDetailsDTO(
                        po.getProducts().getProductID(),
                        po.getProducts().getName(),
                        po.getUnits(),
                        po.getProducts().getPrice(),
                        po.getUnits() * po.getProducts().getPrice()
                ))
                .collect(Collectors.toList());

        double totalCost = cart.stream()
                .mapToDouble(ProductDetailsDTO::getTotalCost)
                .sum();

        Optional<OutOrderStatus> latestStatus = orders.getOrderStatuses().stream()
                .max(Comparator.comparing(OutOrderStatus::getDateOrdersalesStatusChanged));

        String currentStatus = latestStatus.isPresent() ? latestStatus.get().getStatus().getStatusName() : "Unknown";
        LocalDateTime dateOrderSalesStatusChanged = latestStatus.isPresent() ? latestStatus.get().getDateOrdersalesStatusChanged() : null;

        List<OutOrderStatusDTO> statusHistory = orders.getOrderStatuses().stream()
                .map(status -> new OutOrderStatusDTO(
                        status.getOrder().getOrderID(),
                        status.getStatus().getStatusId(),
                        status.getStatus().getStatusName(),
                        status.getDateOrdersalesStatusChanged()
                ))
                .collect(Collectors.toList());


        return new OrdersDTO(
                orders.getOrderID(),
                orders.getCustomer().getCustID(),
                orders.getCustomer().getCompanyName(),
                orders.getPartner().getPartnerID(),
                orders.getPartner().getCompanyName(),
                totalCost,
                cart,
                currentStatus,
                dateOrderSalesStatusChanged,
                statusHistory

        );
    }

    public Orders toEntity(OrdersDTO dto) {
        Orders order = new Orders();
        order.setOrderID(dto.getOrderID());
        order.setCustomer(customersRepository.findById(dto.getCustID()).orElse(null));
        order.setPartner(partnersRepository.findById(dto.getPartnerID()).orElse(null));
        return order;
    }
}

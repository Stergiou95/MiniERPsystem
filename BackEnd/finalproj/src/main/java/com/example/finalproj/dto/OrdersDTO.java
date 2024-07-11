package com.example.finalproj.dto;

import lombok.*;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrdersDTO {
    private Long orderID;
    private Long custID;
    private String companyName;

    private Long partnerID;
    private String partnerName;

    private Double totalCost;
    private List<ProductDetailsDTO> cart;
    private String currentStatus;
    private LocalDateTime dateOrderSalesStatusChanged;
    private List<OutOrderStatusDTO> statusHistory;



}

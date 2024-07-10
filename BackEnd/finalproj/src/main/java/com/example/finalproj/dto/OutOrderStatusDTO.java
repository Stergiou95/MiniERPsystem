package com.example.finalproj.dto;

import lombok.*;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OutOrderStatusDTO {
    private Long orderID;
    private Long statusID;
    private String statusName;
    private LocalDateTime dateOrderSalesStatusChanged;

    public OutOrderStatusDTO(String statusName, LocalDateTime dateOrderSalesStatusChanged) {
        this.statusName = statusName;
        this.dateOrderSalesStatusChanged = dateOrderSalesStatusChanged;
    }
}

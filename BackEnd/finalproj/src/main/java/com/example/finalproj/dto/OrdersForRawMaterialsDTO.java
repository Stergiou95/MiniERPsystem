package com.example.finalproj.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrdersForRawMaterialsDTO {
    private Long rmorderID;
    private Long supplierID;
    private String supplierName;
    private List<RawMaterialsDetailsDTO> rawMaterialsDetails; // Προσθήκη αυτής της γραμμής
    private LocalDateTime dateOrderRmatStatusChanged;
    private double totalCost;
    private String currentStatus;
    private List<RawMaterialsOrderStatusDTO> statusHistory;
}

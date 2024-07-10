package com.example.finalproj.dto;


import com.example.finalproj.model.Locations;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class WarehouseOfRawMaterialsDTO {

    private Long warehouseID;
    private Long locationID;
    private double capacity;
}

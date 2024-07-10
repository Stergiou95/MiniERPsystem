package com.example.finalproj.dto;

import com.example.finalproj.model.Locations;
import com.example.finalproj.model.RawMaterialWarehouseRawMaterial;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class WarehouseDTO {

    private Long warehouseID;

    private double capacity;

    private Long locationID;
}

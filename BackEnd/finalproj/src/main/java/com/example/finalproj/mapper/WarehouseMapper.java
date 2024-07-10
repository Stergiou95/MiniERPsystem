package com.example.finalproj.mapper;

import com.example.finalproj.dto.WarehouseDTO;
import com.example.finalproj.model.WarehousesOfRawMaterials;
import com.example.finalproj.repository.LocationsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class WarehouseMapper {

    @Autowired
    private LocationsRepository locationsRepository;

    public WarehouseDTO toDTO(WarehousesOfRawMaterials warehouse) {
        return new WarehouseDTO(
                warehouse.getWarehouseID(),
                warehouse.getCapacity(), // Διορθώθηκε η σειρά και ο τύπος των πεδίων
                warehouse.getLocation().getLocationID()
        );
    }

    public WarehousesOfRawMaterials toEntity(WarehouseDTO dto) {
        WarehousesOfRawMaterials warehouse = new WarehousesOfRawMaterials();
        warehouse.setWarehouseID(dto.getWarehouseID());
        warehouse.setCapacity(dto.getCapacity());
        warehouse.setLocation(locationsRepository.findById(dto.getLocationID()).orElse(null));
        return warehouse;
    }
}

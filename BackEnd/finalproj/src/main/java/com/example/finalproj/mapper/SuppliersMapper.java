package com.example.finalproj.mapper;

import com.example.finalproj.dto.SuppliersDTO;
import com.example.finalproj.model.Suppliers;
import com.example.finalproj.repository.LocationsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SuppliersMapper {

    @Autowired
    private LocationsRepository locationsRepository;

    public SuppliersDTO toDTO(Suppliers suppliers) {
        return new SuppliersDTO(
                suppliers.getSupplierID(),
                suppliers.getCompanyName(),
                suppliers.getEmail(),
                suppliers.getLocation().getLocationID(),
                suppliers.getLocation().getLocation_name()

        );
    }

    public Suppliers toEntity(SuppliersDTO dto) {
        Suppliers suppliers = new Suppliers();
        suppliers.setSupplierID(dto.getSupplierID());
        suppliers.setCompanyName(dto.getCompanyName());
        suppliers.setEmail(dto.getEmail());
        suppliers.setLocation(locationsRepository.findById(dto.getLocationID()).orElse(null));
        return suppliers;
    }
}

package com.example.finalproj.mapper;

import com.example.finalproj.dto.CustomersDTO;
import com.example.finalproj.model.Customers;
import com.example.finalproj.repository.LocationsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CustomersMapper {

    @Autowired
    private LocationsRepository locationsRepository;

    public CustomersDTO toDTO(Customers customers) {
        return new CustomersDTO(
                customers.getCustID(),
                customers.getCompanyName(),
                customers.getEmail(),
                customers.getLocation().getLocationID(),
                customers.getLocation().getLocation_name()
        );
    }

    public Customers toEntity(CustomersDTO dto) {
        Customers customers = new Customers();
        customers.setCustID(dto.getCustID());
        customers.setCompanyName(dto.getCompanyName());
        customers.setEmail(dto.getEmail());
        customers.setLocation(locationsRepository.findById(dto.getLocationID()).orElse(null));
        return customers;
    }
}

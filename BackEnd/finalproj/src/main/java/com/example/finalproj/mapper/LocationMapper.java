package com.example.finalproj.mapper;

import com.example.finalproj.dto.LocationDTO;
import com.example.finalproj.model.Locations;
import org.springframework.stereotype.Component;

@Component
public class LocationMapper {

    public LocationDTO toDTO(Locations location) {
        return new LocationDTO(
                location.getLocationID(),
                location.getLocation_name()
        );
    }

    public Locations toEntity(LocationDTO dto) {
        Locations location = new Locations();
        location.setLocationID(dto.getLocationID());
        location.setLocation_name(dto.getLocationName());
        return location;
    }
}

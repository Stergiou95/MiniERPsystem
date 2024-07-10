package com.example.finalproj.service;

import com.example.finalproj.dto.LocationDTO;
import com.example.finalproj.model.Locations;

import java.util.List;

public interface LocationsService {
    Locations createLocation(LocationDTO locationsDTO) throws Exception;
    Locations updateLocation(Long locationID, LocationDTO locationsDTO) throws Exception;
    void deleteLocation(Long locationID) throws Exception;
    Locations getLocationById(Long locationID) throws Exception;
    List<LocationDTO> getAllLocations() throws Exception;

}

package com.example.finalproj.service.impl;

import com.example.finalproj.dto.LocationDTO;
import com.example.finalproj.mapper.LocationMapper;
import com.example.finalproj.model.Locations;
import com.example.finalproj.repository.LocationsRepository;
import com.example.finalproj.service.LocationsService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@AllArgsConstructor
@Slf4j
public class LocationsServiceImpl implements LocationsService {

    private final LocationsRepository locationsRepository;
    private final LocationMapper locationsMapper;

    @Override
    public Locations createLocation(LocationDTO locationsDTO) throws Exception {
        Locations location = locationsMapper.toEntity(locationsDTO);
        return locationsRepository.save(location);
    }

    @Override
    public Locations updateLocation(Long locationID, LocationDTO locationsDTO) throws Exception {
        Locations location = locationsRepository.findById(locationID)
                .orElseThrow(() -> new RuntimeException("Location not found with id: " + locationID));

        location.setLocation_name(locationsMapper.toEntity(locationsDTO).getLocation_name());
        return locationsRepository.save(location);
    }

    @Override
    public void deleteLocation(Long locationID) throws Exception {
        if (!locationsRepository.existsById(locationID)) {
            throw new RuntimeException("Location not found with id: " + locationID);
        }
        locationsRepository.deleteById(locationID);
    }

    @Override
    public Locations getLocationById(Long locationID) throws Exception {
        return locationsRepository.findById(locationID)
                .orElseThrow(() -> new RuntimeException("Location not found with id: " + locationID));
    }

    @Override
    public List<LocationDTO> getAllLocations() throws Exception {
        List<Locations> locationsList = locationsRepository.findAll();
        return locationsList.stream()
                .map(locationsMapper::toDTO)
                .collect(Collectors.toList());
    }
}

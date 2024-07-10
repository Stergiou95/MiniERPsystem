package com.example.finalproj.controller;

import com.example.finalproj.dto.LocationDTO;
import com.example.finalproj.service.LocationsService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/locations")
@AllArgsConstructor
@CrossOrigin(origins = "http://127.0.0.1:5500")  // Ανάλογα με τον τοπικό σου server μπορεί να χρειαστεί προσαρμογή
public class LocationsController {

    private final LocationsService locationsService;

    @GetMapping
    public List<LocationDTO> getAllLocations() throws Exception {
        return locationsService.getAllLocations();
    }
}

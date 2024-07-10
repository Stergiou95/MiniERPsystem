package com.example.finalproj.controller;

import com.example.finalproj.dto.RawMaterialsDTO;
import com.example.finalproj.model.RawMaterials;
import com.example.finalproj.service.RawMaterialsService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rawMaterials")
@AllArgsConstructor
@CrossOrigin(origins = "http://127.0.0.1:5500")
public class RawMaterialsController {

    private final RawMaterialsService rawMaterialsService;

    @GetMapping
    public List<RawMaterialsDTO> getAllRawMaterials() throws Exception {
        return rawMaterialsService.getAllRawMaterials();
    }

    @GetMapping("/{id}")
    public RawMaterialsDTO getRawMaterialsById(@PathVariable Long id) throws Exception {
        return rawMaterialsService.getRawMaterialsById(id);
    }

    @PostMapping
    public RawMaterials createRawMaterials(@RequestBody RawMaterialsDTO rawMaterialsDTO) throws Exception {
        return rawMaterialsService.createRawMaterials(rawMaterialsDTO);
    }

    @PutMapping("/{id}")
    public RawMaterialsDTO updateRawMaterials(@PathVariable Long id, @RequestBody RawMaterialsDTO rawMaterialsDTO) throws Exception {
        rawMaterialsDTO.setRawMatID(id);
        return rawMaterialsService.updateRawMaterials(rawMaterialsDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteRawMaterialsById(@PathVariable Long id) throws Exception {
        rawMaterialsService.deleteRawMaterialsById(id);
    }
}

package com.example.finalproj.controller;

import com.example.finalproj.dto.RawMaterialsDTO;
import com.example.finalproj.model.RawMaterialsSuppliers;
import com.example.finalproj.repository.RawMaterialsSuppliersRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/supplierRawMaterials")
@AllArgsConstructor
@CrossOrigin(origins = "http://127.0.0.1:5500")

public class SupplierRawMaterialsController {

    private final RawMaterialsSuppliersRepository rawMaterialsSuppliersRepository;

    @GetMapping("/bySupplier/{supplierId}")
    public ResponseEntity<List<RawMaterialsDTO>> getRawMaterialsBySupplier(@PathVariable Long supplierId) {
        List<RawMaterialsDTO> rawMaterials = rawMaterialsSuppliersRepository.findBySuppliersSupplierID(supplierId)
                .stream()
                .map(rms -> new RawMaterialsDTO(
                        rms.getRawMaterials().getRawMatID(),
                        rms.getRawMaterials().getRawMaterialName(),
                        rms.getRawMaterials().getRawMaterialDescription()
                ))
                .collect(Collectors.toList());

        return ResponseEntity.ok(rawMaterials);
    }
}

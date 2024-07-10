package com.example.finalproj.controller;


import com.example.finalproj.dto.SuppliersDTO;
import com.example.finalproj.model.Suppliers;
import com.example.finalproj.service.SuppliersService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/suppliers")
@AllArgsConstructor
@CrossOrigin(origins = "http://127.0.0.1:5500")
public class SuppliersController {


    private final SuppliersService suppliersService;

    @GetMapping
    public List<SuppliersDTO> getAllSuppliers() throws Exception {
        return suppliersService.getAllSuppliers();
    }

    @GetMapping("/{id}")
    public Suppliers getSupplierById(@PathVariable Long id) throws Exception {
        return suppliersService.getSupplierById(id);
    }

    @PostMapping
    public Suppliers createSupplier(@RequestBody SuppliersDTO suppliersDTO) throws Exception {
        return suppliersService.createSupplier(suppliersDTO);
    }

    @PutMapping("/{id}")
    public SuppliersDTO updateSupplier(@PathVariable Long id, @RequestBody SuppliersDTO suppliersDTO) throws Exception {
        return suppliersService.updateSupplier(id, suppliersDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteSupplier(@PathVariable long id) throws Exception {
        suppliersService.deleteSupplier(id);
    }



}

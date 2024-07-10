package com.example.finalproj.service;

import com.example.finalproj.dto.SuppliersDTO;
import com.example.finalproj.model.Suppliers;

import java.util.List;

public interface SuppliersService {

    Suppliers createSupplier(SuppliersDTO supplierDTO) throws Exception;
    SuppliersDTO updateSupplier(Long supplierId, SuppliersDTO supplierDTO) throws Exception;
    void deleteSupplier(Long supplierId) throws Exception;
    Suppliers getSupplierById(Long supplierId) throws Exception;
    List<SuppliersDTO> getAllSuppliers() throws Exception;
}

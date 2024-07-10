package com.example.finalproj.service.impl;

import com.example.finalproj.dto.SuppliersDTO;
import com.example.finalproj.mapper.SuppliersMapper;
import com.example.finalproj.model.Suppliers;
import com.example.finalproj.repository.SuppliersRepository;
import com.example.finalproj.repository.LocationsRepository;
import com.example.finalproj.service.SuppliersService;
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
public class SuppliersServiceImpl implements SuppliersService {

    private final SuppliersRepository suppliersRepository;
    private final SuppliersMapper suppliersMapper;
    private final LocationsRepository locationsRepository;

    @Override
    public Suppliers createSupplier(SuppliersDTO supplierDTO) throws Exception {
        Suppliers supplier = suppliersMapper.toEntity(supplierDTO);
        supplier.setLocation(locationsRepository.findById(supplierDTO.getLocationID()).orElseThrow(() -> new RuntimeException("Location not found")));
        return suppliersRepository.save(supplier);
    }

    @Override
    public SuppliersDTO updateSupplier(Long supplierId, SuppliersDTO supplierDTO) throws Exception {
        try{
            Suppliers existingSupplier = suppliersRepository.findById(supplierId)
                    .orElseThrow(() -> new RuntimeException("Supplier not found"));

            existingSupplier.setCompanyName(supplierDTO.getCompanyName());
            existingSupplier.setEmail(supplierDTO.getEmail());
            existingSupplier.setLocation(suppliersMapper.toEntity(supplierDTO).getLocation());

            suppliersRepository.save(existingSupplier);
            log.info("Supplier updated succesfully : {}", supplierDTO);
            return suppliersMapper.toDTO(existingSupplier);
        } catch (RuntimeException e) {
            log.info("error while updating supplier : {}", supplierDTO, e);
            throw e;
        } catch (Exception e) {
            log.error("Unexpected error while updating supplier with id {}", supplierId, e);
            throw new RuntimeException("An unexpected error occurred while updating the supplier", e);
        }
    }

    @Override
    public void deleteSupplier(Long supplierId) throws Exception {
        if (!suppliersRepository.existsById(supplierId)) {
            throw new RuntimeException("Supplier not found with id: " + supplierId);
        }
        suppliersRepository.deleteById(supplierId);
    }

    @Override
    public Suppliers getSupplierById(Long supplierId) throws Exception {
        return suppliersRepository.findById(supplierId).orElseThrow(() -> new RuntimeException("Supplier not found with id: " + supplierId));
    }

    @Override
    public List<SuppliersDTO> getAllSuppliers() throws Exception {
        return suppliersRepository.findAll().stream()
                .map(suppliersMapper::toDTO)
                .collect(Collectors.toList());
    }
}

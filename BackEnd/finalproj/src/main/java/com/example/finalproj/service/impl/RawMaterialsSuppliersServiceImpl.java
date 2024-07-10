package com.example.finalproj.service.impl;

import com.example.finalproj.dto.RawMaterialsSuppliersDTO;
import com.example.finalproj.mapper.RawMaterialsSuppliersMapper;
import com.example.finalproj.model.RawMaterialsSuppliers;
import com.example.finalproj.model.RawMaterialsSuppliersID;
import com.example.finalproj.repository.RawMaterialsSuppliersRepository;
import com.example.finalproj.service.RawMaterialsSuppliersService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@AllArgsConstructor
@Slf4j
public class RawMaterialsSuppliersServiceImpl implements RawMaterialsSuppliersService {

    private final RawMaterialsSuppliersRepository rawMaterialsSuppliersRepository;
    private final RawMaterialsSuppliersMapper rawMaterialsSuppliersMapper;

    @Override
    public RawMaterialsSuppliers createRawMaterialsSupplier(RawMaterialsSuppliersDTO rawMaterialsSuppliersDTO) throws Exception {
        RawMaterialsSuppliers rawMaterialsSuppliers = rawMaterialsSuppliersMapper.toEntity(rawMaterialsSuppliersDTO);
        return rawMaterialsSuppliersRepository.save(rawMaterialsSuppliers);
    }

    @Override
    public RawMaterialsSuppliers updateRawMaterialsSupplier(Long rawMatID, Long supplierID, RawMaterialsSuppliersDTO rawMaterialsSuppliersDTO) throws Exception {
        RawMaterialsSuppliersID id = new RawMaterialsSuppliersID(rawMatID, supplierID);
        RawMaterialsSuppliers rawMaterialsSuppliers = rawMaterialsSuppliersRepository.findById(id).orElseThrow(() -> new RuntimeException("Raw Materials Supplier not found with id: " + id));
        rawMaterialsSuppliers.setCostPerUnit(rawMaterialsSuppliersDTO.getCostPerUnit());
        return rawMaterialsSuppliersRepository.save(rawMaterialsSuppliers);
    }

    @Override
    public void deleteRawMaterialsSupplier(Long rawMatID, Long supplierID) throws Exception {
        RawMaterialsSuppliersID id = new RawMaterialsSuppliersID(rawMatID, supplierID);
        if (!rawMaterialsSuppliersRepository.existsById(id)) {
            throw new RuntimeException("Raw Materials Supplier not found with id: " + id);
        }
        rawMaterialsSuppliersRepository.deleteById(id);
    }

    @Override
    public RawMaterialsSuppliers getRawMaterialsSupplierById(Long rawMatID, Long supplierID) throws Exception {
        RawMaterialsSuppliersID id = new RawMaterialsSuppliersID(rawMatID, supplierID);
        return rawMaterialsSuppliersRepository.findById(id).orElseThrow(() -> new RuntimeException("Raw Materials Supplier not found with id: " + id));
    }

    @Override
    public List<RawMaterialsSuppliers> getAllRawMaterialsSuppliers() throws Exception {
        return rawMaterialsSuppliersRepository.findAll();
    }
}

package com.example.finalproj.service.impl;

import com.example.finalproj.dto.RawMaterialsDTO;
import com.example.finalproj.mapper.RawMaterialsMapper;
import com.example.finalproj.model.RawMaterials;
import com.example.finalproj.repository.RawMaterialsRepository;
import com.example.finalproj.service.RawMaterialsService;
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
public class RawMaterialsServiceImp implements RawMaterialsService {

    private final RawMaterialsRepository rawMaterialsRepository;
    private final RawMaterialsMapper rawMaterialsMapper;

    @Override

    public RawMaterials createRawMaterials(RawMaterialsDTO rawMaterialsDTO) throws Exception {
        log.info("Creating raw material: {}", rawMaterialsDTO);
        RawMaterials rawMaterials = rawMaterialsMapper.toEntity(rawMaterialsDTO);
        return rawMaterialsRepository.save(rawMaterials);
    }

    @Override
    public List<RawMaterialsDTO> getAllRawMaterials() throws Exception {
        List<RawMaterials> rawMaterialsList = rawMaterialsRepository.findAll();
        return rawMaterialsList.stream()
                .map(rawMaterialsMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public RawMaterialsDTO getRawMaterialsById(Long id) throws Exception {
        RawMaterials rawMaterials = rawMaterialsRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Raw material not found"));
        rawMaterials.setTotalStockedQuantity(rawMaterials.getTotalStockedQuantity());
        return rawMaterialsMapper.toDTO(rawMaterials);
    }

    @Override
    public RawMaterialsDTO updateRawMaterials(RawMaterialsDTO rawMaterialsDTO) throws Exception {
        RawMaterials rawMaterials = rawMaterialsRepository.findById(rawMaterialsDTO.getRawMatID())
                .orElseThrow(() -> new RuntimeException("Raw material not found"));

        rawMaterials.setRawMaterialName(rawMaterialsDTO.getRawMaterialName());
        rawMaterials.setRawMaterialDescription(rawMaterialsDTO.getRawMaterialDescription());

        RawMaterials updatedRawMaterials = rawMaterialsRepository.save(rawMaterials);

        return rawMaterialsMapper.toDTO(updatedRawMaterials);
    }

    @Override
    public void deleteRawMaterialsById(Long id) throws Exception {
        rawMaterialsRepository.deleteById(id);
    }
}

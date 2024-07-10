package com.example.finalproj.service.impl;

import com.example.finalproj.dto.RawMaterialsOrdersRawMaterialsDTO;
import com.example.finalproj.mapper.RawMaterialsOrdersRawMaterialsMapper;
import com.example.finalproj.model.RawMaterialsOrdersRawMaterials;
import com.example.finalproj.model.RawMaterialsOrdersRawMaterialsId;
import com.example.finalproj.repository.RawMaterialsOrdersRawMaterialsRepository;
import com.example.finalproj.service.RawMaterialsOrdersRawMaterialsService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@AllArgsConstructor
@Slf4j
public class RawMaterialsOrdersRawMaterialsServiceImpl implements RawMaterialsOrdersRawMaterialsService {

    private final RawMaterialsOrdersRawMaterialsRepository repository;
    private final RawMaterialsOrdersRawMaterialsMapper mapper;

    @Override
    public RawMaterialsOrdersRawMaterials addRawMaterialToOrder(RawMaterialsOrdersRawMaterialsDTO dto) throws Exception {
        RawMaterialsOrdersRawMaterials entity = mapper.toEntity(dto);
        return repository.save(entity);
    }

    @Override
    public RawMaterialsOrdersRawMaterials updateRawMaterialInOrder(Long rmorderID, Long rawMatID, RawMaterialsOrdersRawMaterialsDTO dto) throws Exception {
        RawMaterialsOrdersRawMaterialsId id = new RawMaterialsOrdersRawMaterialsId(rmorderID, rawMatID);
        RawMaterialsOrdersRawMaterials entity = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("RawMaterialsOrdersRawMaterials not found with id: " + id));

        entity.setUnits(dto.getUnits());
        return repository.save(entity);
    }

    @Override
    public void removeRawMaterialFromOrder(Long rmorderID, Long rawMatID) throws Exception {
        RawMaterialsOrdersRawMaterialsId id = new RawMaterialsOrdersRawMaterialsId(rmorderID, rawMatID);
        if (!repository.existsById(id)) {
            throw new RuntimeException("RawMaterialsOrdersRawMaterials not found with id: " + id);
        }
        repository.deleteById(id);
    }

    @Override
    public RawMaterialsOrdersRawMaterials getRawMaterialsOrdersRawMaterialsById(Long rmorderID, Long rawMatID) throws Exception {
        RawMaterialsOrdersRawMaterialsId id = new RawMaterialsOrdersRawMaterialsId(rmorderID, rawMatID);
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("RawMaterialsOrdersRawMaterials not found with id: " + id));
    }

    @Override
    public List<RawMaterialsOrdersRawMaterials> getAllRawMaterialsOrdersRawMaterials() throws Exception {
        return repository.findAll();
    }
}

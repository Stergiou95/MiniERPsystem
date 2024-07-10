package com.example.finalproj.service.impl;

import com.example.finalproj.dto.PartnersDTO;
import com.example.finalproj.mapper.LocationMapper;
import com.example.finalproj.mapper.PartnersMapper;
import com.example.finalproj.model.Partners;
import com.example.finalproj.repository.PartnersRepository;
import com.example.finalproj.service.PartnersService;
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
public class PartnersServiceImpl implements PartnersService {

    private final PartnersRepository partnersRepository;
    private final PartnersMapper partnersMapper;
    private final LocationMapper locationMapper;

    @Override
    public Partners createPartner(PartnersDTO partnersDTO) throws Exception {
        Partners partner = partnersMapper.toEntity(partnersDTO);
        return partnersRepository.save(partner);
    }

    @Override
    public List<PartnersDTO> getAllPartners() throws Exception {
        List<Partners> partnersList = partnersRepository.findAll();
        return partnersList.stream()
                .map(partnersMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public PartnersDTO getPartnerById(Long id) throws Exception {
        Partners partners = partnersRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Partner not found"));
        return partnersMapper.toDTO(partners);
    }

    @Override
    public PartnersDTO updatePartner(Long id, PartnersDTO partnersDTO) throws Exception {
        Partners partners = partnersRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Partner not found"));

        partners.setCompanyName(partnersDTO.getCompanyName());
        partners.setEmail(partnersDTO.getEmail());
        partners.setLocation(partnersMapper.toEntity(partnersDTO).getLocation());

        partners = partnersRepository.save(partners);

        return partnersMapper.toDTO(partners);
    }

    @Override
    public void deletePartnerById(Long id) throws Exception {
        if (!partnersRepository.existsById(id)) {
            throw new RuntimeException("Partner not found with id: " + id);
        }
        partnersRepository.deleteById(id);
    }
}

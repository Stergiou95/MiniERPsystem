package com.example.finalproj.service;

import com.example.finalproj.dto.PartnersDTO;
import com.example.finalproj.model.Partners;

import java.util.List;

public interface PartnersService {
    Partners createPartner(PartnersDTO partnersDTO) throws Exception;


    List<PartnersDTO> getAllPartners() throws Exception;
    PartnersDTO getPartnerById(Long id) throws Exception;
    PartnersDTO updatePartner(Long id, PartnersDTO partnersDTO) throws Exception;
    void deletePartnerById(Long id) throws Exception;
}

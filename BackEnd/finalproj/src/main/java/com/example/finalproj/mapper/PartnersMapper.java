package com.example.finalproj.mapper;

import com.example.finalproj.dto.PartnersDTO;
import com.example.finalproj.model.Partners;
import com.example.finalproj.repository.LocationsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PartnersMapper {

    @Autowired
    private LocationsRepository locationsRepository;

    public PartnersDTO toDTO(Partners partner) {
        return new PartnersDTO(
                partner.getPartnerID(),
                partner.getCompanyName(),
                partner.getEmail(),
                partner.getLocation().getLocationID(),
                partner.getLocation().getLocation_name()
        );
    }

    public Partners toEntity(PartnersDTO dto) {
        Partners partner = new Partners();
        partner.setPartnerID(dto.getPartnerID());
        partner.setCompanyName(dto.getCompanyName());
        partner.setEmail(dto.getEmail());
        partner.setLocation(locationsRepository.findById(dto.getLocationID()).orElse(null));
        return partner;
    }
}

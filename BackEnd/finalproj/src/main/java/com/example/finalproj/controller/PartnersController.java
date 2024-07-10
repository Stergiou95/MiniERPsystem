package com.example.finalproj.controller;

import com.example.finalproj.dto.PartnersDTO;
import com.example.finalproj.model.Partners;
import com.example.finalproj.service.PartnersService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/partners")
@AllArgsConstructor
@CrossOrigin(origins = "http://127.0.0.1:5500")
public class PartnersController {

    private final PartnersService partnersService;

    @GetMapping
    public List<PartnersDTO> getAllPartners() throws Exception {
        return partnersService.getAllPartners();
    }

    @GetMapping("/{id}")
    public PartnersDTO getPartnerById(@PathVariable Long id) throws Exception {
        return partnersService.getPartnerById(id);
    }

    @PostMapping
    public Partners createPartner(@RequestBody PartnersDTO partnersDTO) throws Exception {
        return partnersService.createPartner(partnersDTO);
    }

    @PutMapping("/{id}")
    public PartnersDTO updatePartner(@PathVariable Long id, @RequestBody PartnersDTO partnersDTO) throws Exception {
        return partnersService.updatePartner(id, partnersDTO);
    }

    @DeleteMapping("/{id}")
    public void deletePartnerById(@PathVariable Long id) throws Exception {
        partnersService.deletePartnerById(id);
    }
}

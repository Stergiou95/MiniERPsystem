package com.example.finalproj.controller;


import com.example.finalproj.dto.RolesDTO;
import com.example.finalproj.service.RoleService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.management.relation.Role;
import java.util.List;

@RestController
@RequestMapping("/api/roles")
@AllArgsConstructor
@CrossOrigin(origins = "http://127.0.0.1:5500")
public class RolesController {

    private final RoleService roleService;

    @GetMapping
    public List<RolesDTO> getAllRoles() throws Exception{
        return roleService.getAllRoles();
    }
}

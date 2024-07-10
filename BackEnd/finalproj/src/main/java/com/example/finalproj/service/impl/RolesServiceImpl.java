package com.example.finalproj.service.impl;

import com.example.finalproj.dto.RolesDTO;
import com.example.finalproj.mapper.RolesMapper;
import com.example.finalproj.model.Roles;
import com.example.finalproj.repository.RolesRepository;
import com.example.finalproj.service.RoleService;
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
public class RolesServiceImpl  implements RoleService {

    private final RolesRepository rolesRepository;
    private final RolesMapper rolesMapper;

    @Override
    public Roles createRole(RolesDTO rolesDTO) throws Exception {
        return null;
    }

    @Override
    public Roles updateRole(RolesDTO rolesDTO) throws Exception {
        return null;
    }

    @Override
    public Roles getRoleById(int id) throws Exception {
        return null;
    }

    @Override
    public void deleteRoleById(int id) throws Exception {

    }

    @Override
    public List<RolesDTO> getAllRoles() throws Exception {
        List<Roles> rolesList = rolesRepository.findAll();
        return rolesList.stream()
                .map(rolesMapper::toDTO)
                .collect(Collectors.toList());
    }
}

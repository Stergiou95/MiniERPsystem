package com.example.finalproj.service;

import com.example.finalproj.dto.RolesDTO;
import com.example.finalproj.model.Roles;

import java.util.List;

public interface RoleService {

    Roles createRole(RolesDTO rolesDTO) throws Exception;
    Roles updateRole(RolesDTO rolesDTO) throws Exception;
    Roles getRoleById(int id) throws Exception;
    void deleteRoleById(int id) throws Exception;
    List<RolesDTO> getAllRoles() throws Exception;

}

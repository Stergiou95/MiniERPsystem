package com.example.finalproj.mapper;

import com.example.finalproj.dto.RolesDTO;
import com.example.finalproj.model.Roles;
import org.springframework.stereotype.Component;

@Component
public class RolesMapper {

    public RolesDTO toDTO(Roles role) {
        return new RolesDTO(
                role.getRoleID(),
                role.getRoleName()
        );
    }

    public Roles toEntity(RolesDTO dto) {
        Roles role = new Roles();
        role.setRoleID(dto.getRoleID());
        role.setRoleName(dto.getRoleName());
        return role;
    }
}

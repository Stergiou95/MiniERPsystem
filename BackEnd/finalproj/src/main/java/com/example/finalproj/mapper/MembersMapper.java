package com.example.finalproj.mapper;

import com.example.finalproj.dto.MembersDTO;
import com.example.finalproj.model.Members;
import com.example.finalproj.repository.RolesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MembersMapper {

    @Autowired
    private RolesRepository rolesRepository;

    public MembersDTO toDTO(Members member) {
        return new MembersDTO(
                member.getMemberID(),
                member.getFirstname(),
                member.getLastname(),
                member.getRole().getRoleID(),
                member.getRole().getRoleName()
        );
    }

    public Members toEntity(MembersDTO dto) {
        Members member = new Members();
        member.setMemberID(dto.getMemberID());
        member.setFirstname(dto.getLastname());
        member.setLastname(dto.getLastname());
        member.setRole(
                rolesRepository.findById(dto.getRoleID()).orElse(null)
        );
        return member;
    }
}

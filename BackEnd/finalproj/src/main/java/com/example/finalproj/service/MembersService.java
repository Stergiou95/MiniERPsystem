package com.example.finalproj.service;

import com.example.finalproj.dto.MembersDTO;
import com.example.finalproj.model.Members;

import java.util.List;

public interface MembersService {
    Members createMember(MembersDTO membersDTO) throws Exception;
    List<MembersDTO> getAllMembers() throws Exception;
    MembersDTO getMemberById(Long id) throws Exception;
    MembersDTO updateMember(Long memberId, MembersDTO membersDTO) throws Exception;
    void deleteMemberById(Long id) throws Exception;
}

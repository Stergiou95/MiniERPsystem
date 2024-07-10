package com.example.finalproj.service.impl;

import com.example.finalproj.dto.MembersDTO;
import com.example.finalproj.mapper.MembersMapper;
import com.example.finalproj.model.Members;
import com.example.finalproj.repository.MembersRepository;
import com.example.finalproj.service.MembersService;
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
public class MembersServiceImpl implements MembersService {

    private final MembersRepository membersRepository;
    private final MembersMapper membersMapper;

    @Override
    public Members createMember(MembersDTO membersDTO) throws Exception {
        Members member = membersMapper.toEntity(membersDTO);
        return membersRepository.save(member);
    }

    @Override
    public List<MembersDTO> getAllMembers() throws Exception {
        List<Members> membersList = membersRepository.findAll();
        return membersList.stream()
                .map(membersMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public MembersDTO getMemberById(Long id) throws Exception {
        Members member = membersRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Member not found"));
        return membersMapper.toDTO(member);
    }

    @Override
    public MembersDTO updateMember(Long memberId, MembersDTO membersDTO) throws Exception {

        try{
            Members member = membersRepository.findById(membersDTO.getMemberID())
                    .orElseThrow(() -> new RuntimeException("Member not found"));

            member.setFirstname(membersDTO.getFirstname());
            member.setLastname(membersDTO.getLastname());
            member.setRole(membersMapper.toEntity(membersDTO).getRole());

            membersRepository.save(member);
            log.info("member updated succesfully|: {}", membersDTO);
            return membersMapper.toDTO(member);
        } catch (RuntimeException e) {
            log.error("Unexpected error while updating member with id {}", memberId, e);
            throw e;
        } catch (Exception e) {
            log.error("Unexpected error while updating member with id {}", memberId, e);
            throw new RuntimeException("An unexpected error occurred while updating the member", e);
        }

    }

    @Override
    public void deleteMemberById(Long id) throws Exception {
        if (!membersRepository.existsById(id)) {
            throw new RuntimeException("Member not found");
        }

        membersRepository.deleteById(id);
    }
}

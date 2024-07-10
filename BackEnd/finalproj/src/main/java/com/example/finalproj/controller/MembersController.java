package com.example.finalproj.controller;

import com.example.finalproj.dto.MembersDTO;
import com.example.finalproj.model.Members;
import com.example.finalproj.service.MembersService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/members")
@AllArgsConstructor
@CrossOrigin(origins = "http://127.0.0.1:5500")
public class MembersController {

    private final MembersService membersService;

    @GetMapping
    public List<MembersDTO> getAllMembers() throws Exception {
        return membersService.getAllMembers();
    }

    @GetMapping("/{id}")
    public MembersDTO getMemberById(@PathVariable Long id) throws Exception {
        return membersService.getMemberById(id);
    }

    @PostMapping
    public Members createMember(@RequestBody MembersDTO membersDTO) throws Exception {
        return membersService.createMember(membersDTO);
    }

    @PutMapping("/{id}")
    public MembersDTO updateMember(@PathVariable Long id, @RequestBody MembersDTO membersDTO) throws Exception {
        membersDTO.setMemberID(id);
        return membersService.updateMember(id, membersDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteMemberById(@PathVariable Long id) throws Exception {
        membersService.deleteMemberById(id);
    }
}

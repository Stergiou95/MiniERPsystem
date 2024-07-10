package com.example.finalproj.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MembersDTO {
    private Long memberID;
    private String firstname;
    private String lastname;
    private Long roleID;
    private String roleName;

}

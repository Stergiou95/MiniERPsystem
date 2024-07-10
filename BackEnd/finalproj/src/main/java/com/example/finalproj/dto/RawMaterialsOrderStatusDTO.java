package com.example.finalproj.dto;

import lombok.*;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RawMaterialsOrderStatusDTO {
    private Long statusID;
    private String statusName;
    private Long rmorderID;
    private LocalDateTime dateOfStatusChange;
}

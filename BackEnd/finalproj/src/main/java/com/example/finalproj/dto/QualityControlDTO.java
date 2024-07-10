package com.example.finalproj.dto;

import lombok.*;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class QualityControlDTO {
    private Long repID;
    private Long resultID;
    private LocalDateTime reportDate;
}

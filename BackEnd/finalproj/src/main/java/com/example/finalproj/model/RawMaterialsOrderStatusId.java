package com.example.finalproj.model;


import jakarta.persistence.Embeddable;
import lombok.*;

import java.io.Serializable;

@Embeddable
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class RawMaterialsOrderStatusId implements Serializable {

    private Long rmorderID;
    private Long statusID;
}

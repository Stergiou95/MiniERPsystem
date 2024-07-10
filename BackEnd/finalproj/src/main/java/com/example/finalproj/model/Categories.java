package com.example.finalproj.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@Table(name = "CATEGORIES")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Categories {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "categoryID")
    private Long categoryID;

    @Column(name = "category_name", nullable = false, length = 255)  // Αλλαγή εδώ
    private String categoryName;

    // reverse relationship with the products
    @OneToMany(mappedBy = "category")
    @JsonIgnore
    private Set<Products> products;
}

package com.example.finalproj.mapper;

import com.example.finalproj.dto.CategoriesDTO;
import com.example.finalproj.model.Categories;
import org.springframework.stereotype.Component;

@Component
public class CategoriesMapper {

    public CategoriesDTO toDTO(Categories category) {
        return new CategoriesDTO(
                category.getCategoryID(),
                category.getCategoryName()
        );
    }

    public Categories toEntity(CategoriesDTO dto) {
        Categories category = new Categories();
        category.setCategoryID(dto.getCategoryID());
        category.setCategoryName(dto.getCategoryName());
        return category;
    }
}

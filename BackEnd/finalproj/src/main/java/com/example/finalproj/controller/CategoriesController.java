package com.example.finalproj.controller;

import com.example.finalproj.dto.CategoriesDTO;
import com.example.finalproj.model.Categories;
import com.example.finalproj.service.CategoriesService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
@AllArgsConstructor
@CrossOrigin(origins = "http://127.0.0.1:5500")

public class CategoriesController {

    private final CategoriesService categoriesService;

    @GetMapping
    public List<CategoriesDTO> getAllCategories() throws Exception {
        return categoriesService.getCategories();
    }
}

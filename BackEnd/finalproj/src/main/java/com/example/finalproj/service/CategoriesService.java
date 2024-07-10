package com.example.finalproj.service;

import com.example.finalproj.dto.CategoriesDTO;

import java.util.List;

public interface CategoriesService {

    List<CategoriesDTO> getCategories() throws Exception;
}

package com.example.finalproj.service.impl;

import com.example.finalproj.dto.CategoriesDTO;
import com.example.finalproj.mapper.CategoriesMapper;
import com.example.finalproj.model.Categories;
import com.example.finalproj.repository.CategoriesRepository;
import com.example.finalproj.service.CategoriesService;
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
public class CategoriesServiceImpl implements CategoriesService {

    final CategoriesRepository categoriesRepository;
    final CategoriesMapper categoriesMapper;

    @Override
    public List<CategoriesDTO> getCategories() {
        List<Categories> categoriesList = categoriesRepository.findAll();
        return categoriesList.stream()
                .map(categoriesMapper::toDTO)
                .collect(Collectors.toList());
    }
}

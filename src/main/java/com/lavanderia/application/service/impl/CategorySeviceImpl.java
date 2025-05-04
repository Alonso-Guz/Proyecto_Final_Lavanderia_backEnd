package com.lavanderia.application.service.impl;

import com.lavanderia.application.dto.CategoryResponse;
import com.lavanderia.application.mapper.CategoryMapper;
import com.lavanderia.application.service.ICategoryService;
import com.lavanderia.domain.repository.ICategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class CategorySeviceImpl implements ICategoryService {
    private final ICategoryRepository repository;
    private final CategoryMapper categoryMapper;
    @Override
    public List<CategoryResponse> list() {
        return repository.findAll()
                .stream()
                .map(categoryMapper::toDto)
                .toList();
    }
}

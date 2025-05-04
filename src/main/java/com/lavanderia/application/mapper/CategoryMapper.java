package com.lavanderia.application.mapper;

import com.lavanderia.application.dto.CategoryResponse;
import com.lavanderia.domain.entity.CategoryEntity;
import org.springframework.stereotype.Component;

@Component
public class CategoryMapper {
    public CategoryResponse toDto(CategoryEntity entity){
        return CategoryResponse.builder()
                .id(entity.getId())
                .name(entity.getName())
                .description(entity.getDescription())
                .build();
    }
}

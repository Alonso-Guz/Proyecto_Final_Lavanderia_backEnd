package com.lavanderia.application.service;

import com.lavanderia.application.dto.CategoryResponse;

import java.util.List;

public interface ICategoryService {
    List<CategoryResponse> list();
}

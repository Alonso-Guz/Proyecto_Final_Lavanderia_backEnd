package com.lavanderia.web.controller;

import com.lavanderia.application.dto.CategoryResponse;
import com.lavanderia.application.service.ICategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
@RequiredArgsConstructor
public class CategoryController {
    private final ICategoryService service;
    @GetMapping
    public final ResponseEntity<List<CategoryResponse>> list(){
        List<CategoryResponse> responses = service.list();
        return ResponseEntity.ok(responses);
    }
}

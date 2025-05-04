package com.lavanderia.application.service;

import com.lavanderia.application.dto.ArticuloRequestDto;
import com.lavanderia.application.dto.ArticuloResponseDto;

import java.util.List;

public interface IArticuloService {
    ArticuloResponseDto create(ArticuloRequestDto req);
    List<ArticuloResponseDto> listAll();
    ArticuloResponseDto getById(Long id);
    ArticuloResponseDto update(Long id,ArticuloRequestDto req);
    void delete(Long id);

}

package com.lavanderia.application.service.impl;

import com.lavanderia.application.dto.articuloDTO.ArticuloRequestDto;
import com.lavanderia.application.dto.articuloDTO.ArticuloResponseDto;
import com.lavanderia.application.mapper.ArticuloMapper;
import com.lavanderia.application.service.IArticuloService;
import com.lavanderia.domain.entity.Articulo;
import com.lavanderia.domain.repository.IArticuloRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ArticuloServiceIpml implements IArticuloService {
     private  final IArticuloRepository repo;
     private final ArticuloMapper mapper;
    @Override
    public ArticuloResponseDto create(ArticuloRequestDto req) {
        Articulo ent = mapper.toEntity(req);
        Articulo saved = repo.save(ent);
        return  mapper.toResponse(saved);
    }

    @Override
    public List<ArticuloResponseDto> listAll() {
      return  repo.findAll().stream()
              .map(mapper::toResponse)
              .collect(Collectors.toList());
    }

    @Override
    public ArticuloResponseDto getById(Long id) {
       Articulo ent = repo.findById(id)
               .orElseThrow(()->  new RuntimeException("Articulo no encontrado"));
        return  mapper.toResponse(ent);
    }

    @Override
    public ArticuloResponseDto update(Long id, ArticuloRequestDto req) {
        Articulo ent =  repo.findById(id)
                .orElseThrow(()->  new RuntimeException("Articulo no encontrado"));
        mapper.updateEntity(req,ent);
        Articulo updated = repo.save(ent);
        return  mapper.toResponse(updated);
    }

    @Override
    public void delete(Long id) {
            repo.deleteById(id);
    }
}

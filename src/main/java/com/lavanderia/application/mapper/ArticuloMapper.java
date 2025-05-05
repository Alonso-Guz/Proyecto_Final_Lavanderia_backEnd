package com.lavanderia.application.mapper;

import com.lavanderia.application.dto.articuloDTO.ArticuloRequestDto;
import com.lavanderia.application.dto.articuloDTO.ArticuloResponseDto;
import com.lavanderia.domain.entity.Articulo;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ArticuloMapper {
    public Articulo toEntity(ArticuloRequestDto req){
        return Articulo.builder()
                .nombre(req.getNombre())
                .descripcion(req.getDescripcion())
                .precio(req.getPrecio())
                .servicioLav(req.getServicioLav())
                .build();
    }
    public List<ArticuloResponseDto> toArticuloResponseDTOList(List<Articulo> articulos) {
        return articulos.stream()
                .map(mapper::toEntity)
                .collect(Collectors.toList());
    }
    public ArticuloResponseDto toResponse(Articulo ent){
        return  ArticuloResponseDto.builder()
                .id_articulo(ent.getId())
                .nombre(ent.getNombre())
                .descripcion(ent.getDescripcion())
                .servicioLav(ent.getServicioLav())
                .build();
    }
}

package com.lavanderia.application.mapper;

import com.lavanderia.application.dto.servicioLav.ServicioLavRequestDto;
import com.lavanderia.application.dto.servicioLav.ServicioLavResponseDto;
import com.lavanderia.domain.entity.ServicioLav;
import org.springframework.stereotype.Component;

@Component
public class ServicioLavMapper {
    public ServicioLavResponseDto toDto(ServicioLav servicioLav){
        return ServicioLavResponseDto.builder()
                .id(servicioLav.getId())
                .nomServicioLav(servicioLav.getNomServicioLav())
                .build();
    }

    public ServicioLav toEntity(ServicioLavRequestDto requestDto){
        return ServicioLav.builder()
                .nomServicioLav(requestDto.getDescServicioLav())
                .build();
    }

    public ServicioLav toEntityResponse(ServicioLavResponseDto servicioLavResponseDto){
        return ServicioLav.builder()
                .id(servicioLavResponseDto.getId())
                .nomServicioLav(servicioLavResponseDto.getNomServicioLav())
                .build();
    }
}

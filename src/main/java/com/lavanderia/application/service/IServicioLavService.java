package com.lavanderia.application.service;

import com.lavanderia.application.dto.servicioLav.ServicioLavRequestDto;
import com.lavanderia.application.dto.servicioLav.ServicioLavResponseDto;

import java.util.List;

public interface IServicioLavService {
    List<ServicioLavResponseDto>list();
    ServicioLavResponseDto registrar(ServicioLavRequestDto requestDto);
    ServicioLavResponseDto obtenerServicioLavResponseDto(Long id);
}

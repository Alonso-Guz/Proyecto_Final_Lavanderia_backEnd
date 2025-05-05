package com.lavanderia.application.dto.articuloDTO;

import com.lavanderia.application.dto.servicioDTO.ServicioLavResponseDTO;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class ArticuloResponseDto {
    private Long id_articulo;
    private String nombre;
    private String descripcion;
    private BigDecimal precio;
    private ServicioLavResponseDTO servicioLav;
}

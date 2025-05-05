package com.lavanderia.application.dto.articuloDTO;


import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class ArticuloRequestDto {
    private String nombre;
    private String descripcion;
    private BigDecimal precio;
    private Long id_servicio;
}

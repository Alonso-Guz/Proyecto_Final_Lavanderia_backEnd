package com.lavanderia.application.dto.servicioDTO;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ServicioLavResponseDto {
    private Long id;
    private String nomServicioLav;

}

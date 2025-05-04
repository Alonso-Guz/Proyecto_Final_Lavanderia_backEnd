package com.lavanderia.application.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
public class CestaResponseDTO {
    private Long id_cesta;
    private Long cod_user;
    private List<ArticuloResponseDto> artuculos;
}

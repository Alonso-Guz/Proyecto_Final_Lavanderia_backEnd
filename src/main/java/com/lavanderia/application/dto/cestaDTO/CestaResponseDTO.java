package com.lavanderia.application.dto.cestaDTO;

import com.lavanderia.application.dto.articuloDTO.ArticuloResponseDto;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class CestaResponseDTO {
    private Long id_cesta;
    private Long cod_user;
    private List<ArticuloResponseDto> artuculos;
}

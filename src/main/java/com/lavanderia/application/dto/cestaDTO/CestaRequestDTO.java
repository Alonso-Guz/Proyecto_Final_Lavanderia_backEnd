package com.lavanderia.application.dto.cestaDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CestaRequestDTO {
    private Long cod_user;
    private List<Long> id_articulo;
}

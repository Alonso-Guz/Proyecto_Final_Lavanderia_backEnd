package com.lavanderia.application.dto.ordenDTO;

import com.lavanderia.domain.entity.EstadoOrden;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class OrdenResponseDTO {
    private Long id;
    private EstadoOrden estadoOrden;
    private LocalDate fechaOrden;
    private Double total;
}

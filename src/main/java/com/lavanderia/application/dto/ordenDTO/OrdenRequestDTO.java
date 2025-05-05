package com.lavanderia.application.dto.ordenDTO;

import com.lavanderia.domain.entity.EstadoOrden;
import lombok.Data;

import java.time.LocalDate;

@Data
public class OrdenRequestDTO {
    private EstadoOrden estadoOrden;
    private LocalDate fechaOrden;
    private Double total;
}

package com.lavanderia.application.dto.detalleOrdenDTO;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DetalleOrdenResponseDTO {
    private Long id;
    private String numOrden;
    private String nomServicioLav;
    private String nomArticulo;
    private Double precioArt;
    private int cantidad;
    private Double subtotal;
}

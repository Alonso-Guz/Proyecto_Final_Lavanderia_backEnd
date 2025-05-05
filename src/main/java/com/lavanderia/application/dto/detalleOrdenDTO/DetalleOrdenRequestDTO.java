package com.lavanderia.application.dto.detalleOrdenDTO;

import lombok.Data;

@Data
public class DetalleOrdenRequestDTO {
    private Long idOrden;
    private Long idArticulo;
    private int cantidad;
    private Double subtotal;

}

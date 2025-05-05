package com.lavanderia.application.mapper;

import com.lavanderia.application.dto.detalleOrden.DetalleOrdenRequestDTO;
import com.lavanderia.application.dto.detalleOrden.DetalleOrdenResponseDTO;
import com.lavanderia.domain.entity.Articulo;
import com.lavanderia.domain.entity.DetalleOrden;
import com.lavanderia.domain.entity.Orden;
import org.springframework.stereotype.Component;

@Component
public class DetalleOrdenMapper {
    public DetalleOrdenResponseDTO toDto(DetalleOrden detalleOrden){
        return DetalleOrdenResponseDTO.builder()
                .id(detalleOrden.getId())
                .numOrden(detalleOrden.getOrden().getNumOrden())
                .nomServicioLav(detalleOrden.getArticulo().getServicioLav().getNomServicioLav())
                .nomArticulo(detalleOrden.getArticulo().getNomArticulo())
                .precioArt(detalleOrden.getArticulo().getPrecioArticulo())
                .cantidad(detalleOrden.getCantidad())
                .subtotal(detalleOrden.getSubtotal())
                .build();
    }

    public DetalleOrden toEntity(DetalleOrdenRequestDTO requestDTO, Orden orden, Articulo articulo){
        return DetalleOrden.builder()
                .id(requestDTO.getIdOrden())
                .id(requestDTO.getIdArticulo())
                .cantidad(requestDTO.getCantidad())
                .subtotal(requestDTO.getSubtotal())
                .build();
    }

}

package com.lavanderia.application.mapper;

import com.lavanderia.application.dto.orden.OrdenRequestDTO;
import com.lavanderia.application.dto.orden.OrdenResponseDTO;
import com.lavanderia.domain.entity.Orden;
import org.springframework.stereotype.Component;

@Component
public class OrdenMapper {
    public OrdenResponseDTO toDto(Orden orden){
        return OrdenResponseDTO.builder()
                .id(orden.getId())
                .estadoOrden(orden.getEstadoOrden())
                .fechaOrden(orden.getFechaCreacionOrden())
                .total(orden.getTotal())
                .build();
    }

    public Orden toEntity(OrdenRequestDTO requestDTO){
        return Orden.builder()
                .estadoOrden(requestDTO.getEstadoOrden())
                .fechaCreacionOrden(requestDTO.getFechaOrden())
                .total(requestDTO.getTotal())
                .build();
    }

    public Orden toEntityResponse(OrdenResponseDTO ordenResponseDTO){
        return Orden.builder()
                .id(ordenResponseDTO.getId())
                .estadoOrden(ordenResponseDTO.getEstadoOrden())
                .total(ordenResponseDTO.getTotal())
                .build();
    }
}

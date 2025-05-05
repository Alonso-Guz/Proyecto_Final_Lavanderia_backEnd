package com.lavanderia.application.service.impl;

import com.lavanderia.application.dto.detalleOrden.DetalleOrdenRequestDTO;
import com.lavanderia.application.dto.detalleOrden.DetalleOrdenResponseDTO;
import com.lavanderia.application.mapper.DetalleOrdenMapper;
import com.lavanderia.application.service.IDetalleOrdenService;
import com.lavanderia.domain.entity.Articulo;
import com.lavanderia.domain.entity.DetalleOrden;
import com.lavanderia.domain.entity.Orden;
import com.lavanderia.domain.repository.IArticuloRepository;
import com.lavanderia.domain.repository.IDetalleOrdenRepository;
import com.lavanderia.domain.repository.IOrdenRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DetalleOrdenServiceImpl implements IDetalleOrdenService {
    private final IDetalleOrdenRepository detalleOrdenRepository;
    private final IOrdenRepository ordenRepository;
    private final IArticuloRepository articuloRepository;
    private final DetalleOrdenMapper detalleOrdenMapper;

    @Override
    public DetalleOrdenResponseDTO guardar(DetalleOrdenRequestDTO requestDTO) {
        // 1. Buscar la Orden por ID
        Orden orden = ordenRepository.findById(requestDTO.getIdOrden())
                .orElseThrow(() -> new RuntimeException("Orden no encontrada"));

        // 2. Buscar el Artículo por ID
        Articulo articulo = articuloRepository.findById(requestDTO.getIdArticulo())
                .orElseThrow(() -> new RuntimeException("Artículo no encontrado"));

        // 3. Crear DetalleOrden usando el mapper (corregido)
        DetalleOrden detalleOrden = detalleOrdenMapper.toEntity(requestDTO, orden, articulo);

        // 4. Calcular subtotal
         detalleOrden.setSubtotal(articulo.getPrecioArticulo() * requestDTO.getCantidad());

        DetalleOrden detalleGuardado = detalleOrdenRepository.save(detalleOrden);

        // 6. Convertir a ResponseDTO
        return detalleOrdenMapper.toDto(detalleGuardado);
    }
}

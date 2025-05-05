package com.lavanderia.application.service;

import com.lavanderia.application.dto.detalleOrden.DetalleOrdenRequestDTO;
import com.lavanderia.application.dto.detalleOrden.DetalleOrdenResponseDTO;

public interface IDetalleOrdenService {
    DetalleOrdenResponseDTO guardar(DetalleOrdenRequestDTO requestDTO);

}

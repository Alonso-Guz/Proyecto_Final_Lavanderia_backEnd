package com.lavanderia.application.service;

import com.lavanderia.application.dto.orden.OrdenResponseDTO;
import com.lavanderia.domain.entity.Orden;
import com.lavanderia.domain.entity.UserEntity;

import java.util.List;
import java.util.Optional;

public interface IOrdenService {
    List<OrdenResponseDTO> findAll();
    Optional<OrdenResponseDTO> findById(Long id);
    Orden save(Orden orden);
    String generarNumeroOrden();
    List<OrdenResponseDTO> findByUsuario(UserEntity userEntity);
}

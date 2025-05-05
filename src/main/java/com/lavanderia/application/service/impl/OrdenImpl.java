package com.lavanderia.application.service.impl;

import com.lavanderia.application.dto.orden.OrdenResponseDTO;
import com.lavanderia.application.mapper.OrdenMapper;
import com.lavanderia.application.service.IOrdenService;
import com.lavanderia.domain.entity.Orden;
import com.lavanderia.domain.entity.UserEntity;
import com.lavanderia.domain.repository.IOrdenRepository;
import com.lavanderia.domain.repository.IUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OrdenImpl implements IOrdenService {
    private final IOrdenRepository ordenRepository;
    private final OrdenMapper ordenMapper;
    private final IUserRepository userRepository;
    @Override
    public List<OrdenResponseDTO> findAll() {
        List<Orden> ordenes = ordenRepository.findAll();
        return ordenes.stream()
                .map(ordenMapper::toDto)
                .toList();
    }

    @Override
    public Optional<OrdenResponseDTO> findById(Long id) {
        return ordenRepository.findById(id)
                .map(ordenMapper::toDto);
    }

    @Override
    public Orden save(Orden orden) {
        // Generar número de orden automáticamente
        orden.setNumOrden(generarNumeroOrden());

        // Si necesitas crear una orden desde DTO:
        // Orden orden = ordenMapper.toEntity(ordenRequestDTO);
        return ordenRepository.save(orden);
    }

    @Override
    public String generarNumeroOrden() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        String timestamp = dateFormat.format(new Date());
        return "ORDEN-" + timestamp;
    }

    @Override
    public List<OrdenResponseDTO> findByUsuario(UserEntity userEntity) {
        List<Orden> ordenes = ordenRepository.findByUsuario(userEntity);
        return ordenes.stream()
                .map(ordenMapper::toDto)
                .toList();
    }
}

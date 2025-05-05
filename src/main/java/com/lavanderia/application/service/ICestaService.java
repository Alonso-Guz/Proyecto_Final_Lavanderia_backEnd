package com.lavanderia.application.service;

import com.lavanderia.application.dto.cestaDTO.CestaRequestDTO;
import com.lavanderia.application.dto.cestaDTO.CestaResponseDTO;

import java.util.List;

public interface ICestaService {
CestaResponseDTO create(CestaRequestDTO requestDTO);
CestaResponseDTO getById(Long id);
List<CestaResponseDTO> listAll();
CestaResponseDTO update(Long id, CestaRequestDTO requestDTO);
void delete(Long id);

CestaResponseDTO addArtuculoToCesta(Long id_cesta, Long id_articulo);
CestaResponseDTO removeArticuloFromCesta(Long id_cesta, Long id_articulo);
}

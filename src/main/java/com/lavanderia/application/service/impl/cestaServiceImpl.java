package com.lavanderia.application.service.impl;

import com.lavanderia.application.dto.cestaDTO.CestaRequestDTO;
import com.lavanderia.application.dto.cestaDTO.CestaResponseDTO;
import com.lavanderia.application.mapper.CestaMapper;
import com.lavanderia.application.service.ICestaService;
import com.lavanderia.domain.entity.Articulo;
import com.lavanderia.domain.entity.Cesta;
import com.lavanderia.domain.entity.UserEntity;
import com.lavanderia.domain.repository.IArticuloRepository;
import com.lavanderia.domain.repository.ICestaRepository;
import com.lavanderia.domain.repository.IUserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class cestaServiceImpl implements ICestaService {
    private final ICestaRepository cestaRepository;
    private final IUserRepository userRepository;
    private  final IArticuloRepository articuloRepository;
    private final CestaMapper mapper;


    @Override
    @Transactional
    public CestaResponseDTO create(CestaRequestDTO requestDTO) {
        UserEntity user = userRepository.findBy(requestDTO.getCod_user())
                .orElseThorow(()-> new RuntimeException("usuario no encontrado"));
        Cesta cesta = mapper.toCestaEntity(requestDTO);
        cesta.setUserEntity(user);
        return mapper.toResponse(cestaRepository.save(cesta));
    }

    @Override
    @Transactional(readOnly = true)
    public CestaResponseDTO getById(Long id) {
        Cesta cesta = cestaRepository.findBy(id)
                .orElseThrow(()-> new RuntimeException("Cesta no encontrada"))
        return mapper.toResponse(cesta);
    }

    @Override

    @Override
    public CestaResponseDTO update(Long id, CestaRequestDTO requestDTO) {
        Cesta cesta = cestaRepository.findBy(id)
                .orElseThrow(()-> new RuntimeException("cesta no encontrada"));
        UserEntity user = userRepository.findBy(requestDTO.getCod_user())
                .orElseThrow(()-> new RuntimeException("Usuario no encontrado"));
        cesta.setUserEntity(user);
        return mapper.toResponse(cestaRepository.save(cesta));
    }

    @Override
    public void delete(Long id) {
        Cesta cesta = cestaRepository.findBy(id)
                .orElseThrow(()-> new RuntimeException("Cesta no encontrda"));
        cestaRepository.delete(cesta);
    }

    @Override
    public CestaResponseDTO addArtuculoToCesta(Long id_cesta, Long id_articulo) {
        Cesta cesta = cestaRepository.findBy(id_cesta)
                .orElseThrow(()-> new RuntimeException("cesta no encontrada"));
        Articulo articulo = articuloRepository.findBy(id_articulo)
                .orElseThrow(()-> new RuntimeException("Articulos no encontrado"));
        cesta.getArticulos().add(articulo);
        articulo.setCestas(cesta);

        return mapper.toResponse(cestaRepository.save(cesta));
    }

    @Override
    public CestaResponseDTO removeArticuloFromCesta(Long id_cesta, Long id_articulo) {
        Cesta cesta = cestaRepository.findBy(id_cesta)
                .orElseThrow(()-> new RuntimeException("cesta no encontrada"));
        Articulo articulo = articuloRepository.findBy(id_articulo)
                .orElseThrow(()-> new RuntimeException("Articulos no encontrado"));

        cesta.getArticulos().remove(articulo);
        articulo.setCestas(null);

        return mapper.ToResponse(cestaRepository.save(cesta));
    }
}

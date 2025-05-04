package com.lavanderia.application.mapper;

import com.lavanderia.application.dto.CestaRequestDTO;
import com.lavanderia.application.dto.CestaResponseDTO;
import com.lavanderia.domain.entity.Cesta;
import com.lavanderia.domain.entity.UserEntity;

public class CestaMapper {
    public static CestaResponseDTO cestaResponseDTO(Cesta cesta){
        return CestaResponseDTO.builder()
                .id_cesta(cesta.getId())
                .cod_user(cesta.getUserEntity().getId())
                .artuculos(toArticuloResponseDTOList(cesta.getArticulos()))
                .build();
    }
    public static Cesta toCestaEntity(CestaRequestDTO requestDTO, UserEntity user){
        return Cesta.builder()
                .userEntity(user)
                .build();
    }
}

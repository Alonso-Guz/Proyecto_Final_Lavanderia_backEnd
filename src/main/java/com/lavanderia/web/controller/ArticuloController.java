package com.lavanderia.web.controller;

import com.lavanderia.application.dto.ArticuloRequestDto;
import com.lavanderia.application.dto.ArticuloResponseDto;
import com.lavanderia.application.service.IArticuloService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/articulos")
@RequiredArgsConstructor
public class ArticuloController {
   private  final IArticuloService service;

    // Solo ADMIN puede listar

    @GetMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<List<ArticuloResponseDto>> listAll(){
        return  ResponseEntity.ok(service.listAll());
    }
    // CLIENTE y TRABAJADOR pueden crear
    @PostMapping
    @PreAuthorize("hasAnyRole('CLIENTE', 'TRABAJADOR')")
    public ResponseEntity<ArticuloResponseDto> create(@RequestBody ArticuloRequestDto req){
        ArticuloResponseDto resp = service.create(req);
        return  ResponseEntity.created(URI.create("/api/articulos/" + resp.getId())).body(resp);

    }
    // Todos los roles pueden consultar por ID
    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('CLIENTE', 'TRABAJADOR', 'ADMIN')")
    public  ResponseEntity<ArticuloResponseDto> getById(@PathVariable Long id){
        return ResponseEntity.ok(service.getById(id));
    }
    // Solo TRABAJADOR y ADMIN pueden actualizar
    @PutMapping("/{id}")
    @PreAuthorize("hasAnyRole('TRABAJADOR', 'ADMIN')")
    public  ResponseEntity<ArticuloResponseDto> update(@PathVariable Long id,@RequestBody ArticuloRequestDto req){
     return ResponseEntity.ok(service.update(id, req));
    }
    // Solo ADMIN puede eliminar
    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        service.delete(id);
        return  ResponseEntity.noContent().build();
    }
}

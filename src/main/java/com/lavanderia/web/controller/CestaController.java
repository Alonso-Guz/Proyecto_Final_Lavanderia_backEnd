package com.lavanderia.web.controller;

import com.lavanderia.application.dto.CestaRequestDTO;
import com.lavanderia.application.dto.CestaResponseDTO;
import com.lavanderia.application.service.ICestaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class CestaController {
    private final ICestaService cestaService;

    @PostMapping
    public ResponseEntity<CestaResponseDTO> crear(@RequestBody CestaRequestDTO requestDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(cestaService.create(requestDTO));
    }

    @GetMapping("/{id}")
    public  ResponseEntity<CestaResponseDTO> getById(@PathVariable Long id){
        return ResponseEntity.ok(cestaService.getById(id));
    }
    @GetMapping
    public ResponseEntity<List<CestaResponseDTO>> listAll(){
        return ResponseEntity.ok(cestaService.update(id, requesDTO));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        cestaService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{id_cesat}/articulos/{id_articulos}")
    public ResponseEntity<CestaResponseDTO> addArticulo(@PathVariable Long id_cesat,@PathVariable Long id_articulos){
        return ResponseEntity.ok(cestaService.addArtuculoToCesta(id_cesat, id_articulos));
    }

    @PostMapping("/{id_cesat}/articulos/{id_articulos}")
    public ResponseEntity<CestaResponseDTO> remoceArticulo(@PathVariable Long id_cesat,@PathVariable Long id_articulos){
        return ResponseEntity.ok(cestaService.removeArticuloFromCesta(id_cesat, id_articulos));
    }
}

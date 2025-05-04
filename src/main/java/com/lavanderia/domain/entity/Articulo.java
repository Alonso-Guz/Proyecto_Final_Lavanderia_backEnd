package com.lavanderia.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Table(name = "articulos")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Articulo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_articulo")
    private Long id;

    private String nombre;

    private String descripcion;

    private BigDecimal precio;

    @ManyToOne
    @JoinColumn(name = "servicioLav_id")
    private ServicioLav servicioLav;

    @ManyToOne
    @JoinColumn(name = "id_cesta")
    private Cesta cestas;

}

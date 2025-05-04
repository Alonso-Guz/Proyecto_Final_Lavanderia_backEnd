package com.lavanderia.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Table(name = "detalleOrden")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class DetalleOrden {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "cantidad", nullable = false)
    private Double cantidad;

    @Column(name = "subtotal", nullable = false, precision = 12, scale = 2)
    private BigDecimal subtotal;

    // Relación: Muchos Items pertenecen a una orden
    @ManyToOne(optional = false, cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
    @JoinColumn(name = "orden_id", nullable = false)
    private Orden orden;

    // Relación: Muchos detalles de orden pertenecen a un artículo (o ítem de servicio)
    @ManyToOne(optional = false, cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
    @JoinColumn(name = "id_articulo", nullable = false)
    private Articulo articulo;
}

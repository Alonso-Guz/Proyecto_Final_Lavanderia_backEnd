package com.lavanderia.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "ordenes")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Orden {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "orden_id")
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 30)
    private EstadoOrden estadoOrden;

    @Column(name = "FechaOrden", nullable = false, updatable = false)
    private LocalDateTime fechaOrden;

    @PrePersist
    private void asignacionFechaOrden() {
        this.fechaOrden = LocalDateTime.now();
    }

    @Column(precision = 12, scale = 2)
    private BigDecimal total;

    // Relación: Muchas órdenes pertenecen a un usuario
    @ManyToOne(optional=false, cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
    @JoinColumn
    private UserEntity cliente;


}

package com.lavanderia.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "servicio_Lav")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class ServicioLav {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_servicio")
    private Long id;

    @Column(name = "descripcion", nullable = false)
    private String descripcion;

    @OneToMany(mappedBy = "servicio_Lav", cascade = CascadeType.ALL)
    @JoinColumn(name = "id_articulo", nullable = false)
    private List<Articulo> articulos = new ArrayList<>();
}

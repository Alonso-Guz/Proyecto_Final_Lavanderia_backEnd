package com.lavanderia.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "cesta")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Cesta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cesta")
    private Long Id;

    @OneToOne
    @JoinColumn(name="cod_user")
    private UserEntity userEntity;

    @OneToMany(mappedBy = "cestas", cascade = CascadeType.ALL)
    private List<Articulo> articulos;
}

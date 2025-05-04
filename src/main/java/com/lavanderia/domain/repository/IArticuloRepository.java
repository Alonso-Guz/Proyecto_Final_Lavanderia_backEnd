package com.lavanderia.domain.repository;

import com.lavanderia.domain.entity.Articulo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IArticuloRepository extends JpaRepository<Articulo, Long> {
}

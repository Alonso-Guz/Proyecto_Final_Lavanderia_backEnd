package com.lavanderia.domain.repository;

import com.lavanderia.domain.entity.Cesta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICestaRepository extends JpaRepository<Cesta, Long> {
}

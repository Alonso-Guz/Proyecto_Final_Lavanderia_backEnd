package com.lavanderia.domain.repository;

import com.lavanderia.domain.entity.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRoleRepository extends JpaRepository<RoleEntity, String> {
}

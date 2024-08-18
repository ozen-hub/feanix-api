package com.feanix.system.repository;

import com.feanix.system.entity.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRoleRepo extends JpaRepository<UserRole,String> {
    public Optional<UserRole> findByRoleName(String role);
}

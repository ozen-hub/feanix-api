package com.feanix.system.repository;

import com.feanix.system.entity.SystemUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SystemUserRepo extends JpaRepository<SystemUser,String> {
    public Optional<SystemUser> findByUsername(String username);
}

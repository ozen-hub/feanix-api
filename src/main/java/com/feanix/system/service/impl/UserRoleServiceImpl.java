package com.feanix.system.service.impl;

import com.feanix.system.entity.UserRole;
import com.feanix.system.repository.UserRoleRepo;
import com.feanix.system.service.UserRoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserRoleServiceImpl implements UserRoleService {

    private final UserRoleRepo roleRepo;

    @Override
    public void initializeUserRoles() {
        List<UserRole> allSelectedData = roleRepo.findAll();
        if (allSelectedData.isEmpty()) {
            UserRole user = UserRole.builder().roleId(UUID.randomUUID().toString()).roleName("USER").build();
            UserRole admin = UserRole.builder().roleId(UUID.randomUUID().toString()).roleName("ADMIN").build();

            roleRepo.saveAll(List.of(user, admin));
        }
    }
}

package com.feanix.system.service.impl;

import com.feanix.system.dto.request.RequestSystemUserDto;
import com.feanix.system.entity.SystemUser;
import com.feanix.system.entity.UserRole;
import com.feanix.system.exception.DuplicateEntryException;
import com.feanix.system.exception.EntryNotFoundException;
import com.feanix.system.repository.SystemUserRepo;
import com.feanix.system.repository.UserRoleRepo;
import com.feanix.system.service.SystemUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

@Service
@Transactional
@RequiredArgsConstructor
public class SystemUserServiceImpl implements SystemUserService {

    private final SystemUserRepo systemUserRepo;
    private final UserRoleRepo userRoleRepo;

    @Override
    public void signup(RequestSystemUserDto dto) {
        Optional<SystemUser> selectedUserData = systemUserRepo.findByUsername(dto.getUsername());
        if (selectedUserData.isPresent()) {
            throw new DuplicateEntryException("User email already exists");
        }

        Optional<UserRole> selectedUserRoleData = userRoleRepo.findByRoleName("USER");

        if(selectedUserRoleData.isEmpty()){
            throw new EntryNotFoundException("Role was not found");
        }

        Set<UserRole> roles = new HashSet<>();
        roles.add(selectedUserRoleData.get());

        SystemUser systemUser = SystemUser.builder()
                .userId(UUID.randomUUID().toString())
                .address(dto.getAddress())
                .isAccountNonExpired(true)
                .roles(roles)// USER,ADMIN
                .isAccountNonLocked(true)
                .isCredentialsNonExpired(true)
                .isEnabled(true)
                .password(dto.getPassword())// encrypt
                .username(dto.getUsername())
                .build();

        systemUserRepo.save(systemUser);
    }

    @Override
    public void initializeSystemAdmin() {
        Optional<SystemUser> selectedUserData = systemUserRepo.findByUsername("abc@gmail.com");
        if (selectedUserData.isPresent()) {
            return;
        }

        Optional<UserRole> selectedUserRoleData = userRoleRepo.findByRoleName("ADMIN");

        if(selectedUserRoleData.isEmpty()){
            throw new EntryNotFoundException("Role was not found");
        }

        Set<UserRole> roles = new HashSet<>();
        roles.add(selectedUserRoleData.get());

        SystemUser systemUser = SystemUser.builder()
                .userId(UUID.randomUUID().toString())
                .address("Panadura")
                .isAccountNonExpired(true)
                .roles(roles)// ADMIN
                .isAccountNonLocked(true)
                .isCredentialsNonExpired(true)
                .isEnabled(true)
                .password("1234")// encrypt
                .username("abc@gmail.com")
                .build();

        systemUserRepo.save(systemUser);
    }

}

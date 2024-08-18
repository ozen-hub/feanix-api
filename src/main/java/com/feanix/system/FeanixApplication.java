package com.feanix.system;

import com.feanix.system.service.SystemUserService;
import com.feanix.system.service.UserRoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@RequiredArgsConstructor
public class FeanixApplication implements CommandLineRunner {

    private final UserRoleService userRoleService;
    private final SystemUserService systemUserService;

    public static void main(String[] args) {
        SpringApplication.run(FeanixApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        userRoleService.initializeUserRoles();
        systemUserService.initializeSystemAdmin();
    }
}

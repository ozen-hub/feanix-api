package com.feanix.system.service;

import com.feanix.system.dto.request.RequestSystemUserDto;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface SystemUserService extends UserDetailsService {
    public void signup(RequestSystemUserDto dto);
    public void initializeSystemAdmin();
}

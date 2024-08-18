package com.feanix.system.service;

import com.feanix.system.dto.request.RequestSystemUserDto;

public interface SystemUserService {
    public void signup(RequestSystemUserDto dto);
    public void initializeSystemAdmin();
}

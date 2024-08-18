package com.feanix.system.api;

import com.feanix.system.dto.request.RequestSystemUserDto;
import com.feanix.system.service.SystemUserService;
import com.feanix.system.util.StandardResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/system-users")
@RequiredArgsConstructor
public class SystemUserController {

    private final SystemUserService userService;

    @PostMapping("/visitor/signup") // http://localhost:8081/api/v1/system-users/visitor/signup
    public ResponseEntity<StandardResponseDto> signup(@RequestBody RequestSystemUserDto dto) {
        userService.signup(dto);
        return new ResponseEntity<>(
                new StandardResponseDto(201, "user was registered", null),
                HttpStatus.CREATED
        );
    }
}

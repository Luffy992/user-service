package com.som.userservice.controller;

import com.som.userservice.dto.LoginRequest;
import com.som.userservice.dto.LoginResponse;
import com.som.userservice.dto.RegisterRequest;
import com.som.userservice.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService
            userService;

    @PostMapping("/register")
    public String register(
            @RequestBody RegisterRequest request) {

        return userService.register(
                request
        );
    }

    @PostMapping("/login")
    public LoginResponse login(
            @RequestBody LoginRequest request) {

        return userService.login(
                request
        );
    }

    @GetMapping("/me")
    public String me(
            Authentication authentication) {

        return authentication.getName();
    }

    @GetMapping("/admin")
    public String admin() {

        return "Admin Access Granted";
    }

    @GetMapping("/test")
    public String test() {

        return "Hello from User Service";
    }
}
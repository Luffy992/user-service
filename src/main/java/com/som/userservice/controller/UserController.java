package com.som.userservice.controller;

import com.som.userservice.dto.RegisterRequest;
import com.som.userservice.service.UserService;
import lombok.RequiredArgsConstructor;
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
}
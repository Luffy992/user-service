package com.som.userservice.service;

import com.som.userservice.dto.RegisterRequest;
import com.som.userservice.entity.User;
import com.som.userservice.exception.EmailAlreadyExistsException;
import com.som.userservice.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository
            userRepository;

    private final PasswordEncoder
            passwordEncoder;

    public String register(
            RegisterRequest request) {

        if (userRepository
                .findByEmail(
                        request.getEmail()
                )
                .isPresent()) {

            throw new EmailAlreadyExistsException(
                    "Email already exists"
            );
        }

        User user =
                User.builder()
                        .name(
                                request.getName()
                        )
                        .email(
                                request.getEmail()
                        )
                        .password(
                                passwordEncoder.encode(
                                    request.getPassword()
                        )
                )
                        .build();

        userRepository.save(
                user
        );

        return "User Registered Successfully";
    }


}
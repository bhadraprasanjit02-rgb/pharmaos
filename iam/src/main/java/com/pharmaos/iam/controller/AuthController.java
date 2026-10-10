package com.pharmaos.iam.controller;

import com.pharmaos.iam.dto.auth.LoginRequest;
import com.pharmaos.iam.dto.auth.LoginResponse;
import com.pharmaos.iam.dto.auth.RegisterRequest;
import com.pharmaos.iam.dto.auth.RegisterResponse;
import com.pharmaos.iam.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<RegisterResponse> register(
            @RequestBody RegisterRequest request) {

        return new ResponseEntity<>(
                authService.register(request),
                HttpStatus.CREATED
        );
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(
            @RequestBody LoginRequest request) {

        return ResponseEntity.ok(
                authService.login(request)
        );
    }
}
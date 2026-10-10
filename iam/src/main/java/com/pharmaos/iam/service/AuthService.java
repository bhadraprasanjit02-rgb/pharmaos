package com.pharmaos.iam.service;

import com.pharmaos.iam.dto.auth.LoginRequest;
import com.pharmaos.iam.dto.auth.LoginResponse;
import com.pharmaos.iam.dto.auth.RegisterRequest;
import com.pharmaos.iam.dto.auth.RegisterResponse;

public interface AuthService {

    RegisterResponse register(RegisterRequest request);

    LoginResponse login(LoginRequest request);

}
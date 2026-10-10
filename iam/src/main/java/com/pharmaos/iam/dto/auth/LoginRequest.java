package com.pharmaos.iam.dto.auth;

import lombok.Data;

@Data
public class LoginRequest {

    private String username;   // Email or Employee Code
    private String password;

}
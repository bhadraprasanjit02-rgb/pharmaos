package com.pharmaos.iam.service.impl;

import com.pharmaos.iam.dto.auth.LoginRequest;
import com.pharmaos.iam.dto.auth.LoginResponse;
import com.pharmaos.iam.dto.auth.RegisterRequest;
import com.pharmaos.iam.dto.auth.RegisterResponse;
import com.pharmaos.iam.entity.Role;
import com.pharmaos.iam.entity.User;
import com.pharmaos.iam.entity.UserRole;
import com.pharmaos.iam.repository.RoleRepository;
import com.pharmaos.iam.repository.UserRepository;
import com.pharmaos.iam.repository.UserRoleRepository;
import com.pharmaos.iam.security.jwt.JwtService;
import com.pharmaos.iam.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final UserRoleRepository userRoleRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;

    @Override
    public RegisterResponse register(RegisterRequest request) {

        // ==============================
        // CHECK DUPLICATES
        // ==============================
        if (userRepository.existsByEmail(request.getEmail())) {
            throw new RuntimeException("Email already exists.");
        }

        if (userRepository.existsByEmployeeCode(request.getEmployeeCode())) {
            throw new RuntimeException("Employee Code already exists.");
        }

        if (userRepository.existsByMobile(request.getMobile())) {
            throw new RuntimeException("Mobile number already exists.");
        }

        // ==============================
        // CREATE USER
        // ==============================
        User user = new User();

        user.setEmployeeCode(request.getEmployeeCode());
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setEmail(request.getEmail());
        user.setMobile(request.getMobile());
        user.setDesignation(request.getDesignation());
        user.setDepartment(request.getDepartment());

        user.setPassword(passwordEncoder.encode(request.getPassword()));

        user.setEnabled(true);
        user.setAccountLocked(false);
        user.setAccountExpired(false);
        user.setCredentialsExpired(false);

        User savedUser = userRepository.save(user);

        // ==============================
        // ASSIGN ROLE
        // ==============================
        final String roleName =
                (request.getRole() == null || request.getRole().isBlank())
                        ? "MR"
                        : request.getRole().trim().toUpperCase();

        Role role = roleRepository.findByName(roleName)
                .orElseThrow(() ->
                        new RuntimeException("Role not found: " + roleName));

        UserRole userRole = new UserRole();
        userRole.setUser(savedUser);
        userRole.setRole(role);

        userRoleRepository.save(userRole);

        // ==============================
        // LOG
        // ==============================
        System.out.println("=================================");
        System.out.println("USER REGISTERED SUCCESSFULLY");
        System.out.println("Email : " + savedUser.getEmail());
        System.out.println("Role  : " + role.getName());
        System.out.println("=================================");

        return new RegisterResponse("User Registered Successfully");
    }

    @Override
    public LoginResponse login(LoginRequest request) {

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getUsername(),
                        request.getPassword()
                )
        );

        String token = jwtService.generateToken(request.getUsername());

        return new LoginResponse(
                token,
                "Bearer",
                86400L
        );
    }
}
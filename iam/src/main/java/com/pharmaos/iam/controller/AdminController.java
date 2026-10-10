package com.pharmaos.iam.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdminController {

    @GetMapping("/api/v1/admin")
    @PreAuthorize("hasRole('ADMIN')")
    public String admin() {
        return "Welcome Admin";
    }

    @GetMapping("/api/v1/mr")
    @PreAuthorize("hasRole('MR')")
    public String mr() {
        return "Welcome MR";
    }
}
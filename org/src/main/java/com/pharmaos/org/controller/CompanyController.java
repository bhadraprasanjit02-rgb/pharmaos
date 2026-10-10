package com.pharmaos.org.controller;

import com.pharmaos.org.dto.CompanyRequest;
import com.pharmaos.org.dto.CompanyResponse;
import com.pharmaos.org.service.CompanyService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/companies")
@RequiredArgsConstructor
public class CompanyController {

    private final CompanyService companyService;

    // ==========================================
    // TEST API
    // ==========================================
    @GetMapping("/test")
    public String test() {
        return "Company Controller Working";
    }

    // ==========================================
    // CREATE COMPANY
    // ==========================================
    @PostMapping
    @PreAuthorize("hasRole('SUPER_ADMIN') or hasRole('ADMIN')")
    public ResponseEntity<CompanyResponse> create(
            @Valid @RequestBody CompanyRequest request) {

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(companyService.create(request));
    }

    // ==========================================
    // GET COMPANY BY ID
    // ==========================================
    @GetMapping("/{id}")
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<CompanyResponse> getById(
            @PathVariable UUID id) {

        return ResponseEntity.ok(
                companyService.getById(id)
        );
    }

    // ==========================================
    // GET ALL COMPANIES
    // ==========================================
    @GetMapping
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<List<CompanyResponse>> getAll() {

        return ResponseEntity.ok(
                companyService.getAll()
        );
    }

    // ==========================================
    // UPDATE COMPANY
    // ==========================================
    @PutMapping("/{id}")
    @PreAuthorize("hasRole('SUPER_ADMIN') or hasRole('ADMIN')")
    public ResponseEntity<CompanyResponse> update(
            @PathVariable UUID id,
            @Valid @RequestBody CompanyRequest request) {

        return ResponseEntity.ok(
                companyService.update(id, request)
        );
    }

    // ==========================================
    // DELETE COMPANY
    // ==========================================
    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('SUPER_ADMIN')")
    public ResponseEntity<Void> delete(
            @PathVariable UUID id) {

        companyService.delete(id);

        return ResponseEntity.noContent().build();
    }
}
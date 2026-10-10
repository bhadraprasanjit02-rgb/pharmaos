package com.pharmaos.org.controller;

import com.pharmaos.org.dto.BusinessUnitRequest;
import com.pharmaos.org.dto.BusinessUnitResponse;
import com.pharmaos.org.service.BusinessUnitService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/business-units")
@RequiredArgsConstructor
public class BusinessUnitController {

    private final BusinessUnitService businessUnitService;

    // ==========================================
    // TEST API
    // ==========================================
    @GetMapping("/test")
    public String test() {
        return "Business Unit Controller Working";
    }

    // ==========================================
    // CREATE BUSINESS UNIT
    // ==========================================
    @PostMapping
    @PreAuthorize("hasRole('SUPER_ADMIN') or hasRole('ADMIN')")
    public ResponseEntity<BusinessUnitResponse> create(
            @Valid @RequestBody BusinessUnitRequest request) {

        BusinessUnitResponse response =
                businessUnitService.create(request);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    // ==========================================
    // GET BY ID
    // ==========================================
    @GetMapping("/{id}")
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<BusinessUnitResponse> getById(
            @PathVariable UUID id) {

        return ResponseEntity.ok(
                businessUnitService.getById(id)
        );
    }

    // ==========================================
    // GET ALL
    // ==========================================
    @GetMapping
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<List<BusinessUnitResponse>> getAll() {

        return ResponseEntity.ok(
                businessUnitService.getAll()
        );
    }

    // ==========================================
    // GET BY COMPANY
    // ==========================================
    @GetMapping("/company/{companyId}")
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<List<BusinessUnitResponse>> getByCompany(
            @PathVariable UUID companyId) {

        return ResponseEntity.ok(
                businessUnitService.getByCompany(companyId)
        );
    }

    // ==========================================
    // UPDATE
    // ==========================================
    @PutMapping("/{id}")
    @PreAuthorize("hasRole('SUPER_ADMIN') or hasRole('ADMIN')")
    public ResponseEntity<BusinessUnitResponse> update(
            @PathVariable UUID id,
            @Valid @RequestBody BusinessUnitRequest request) {

        return ResponseEntity.ok(
                businessUnitService.update(id, request)
        );
    }

    // ==========================================
    // DELETE
    // ==========================================
    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('SUPER_ADMIN')")
    public ResponseEntity<Void> delete(
            @PathVariable UUID id) {

        businessUnitService.delete(id);

        return ResponseEntity.noContent().build();
    }
}
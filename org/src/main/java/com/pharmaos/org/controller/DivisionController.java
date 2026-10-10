package com.pharmaos.org.controller;

import com.pharmaos.org.dto.DivisionRequest;
import com.pharmaos.org.dto.DivisionResponse;
import com.pharmaos.org.service.DivisionService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/divisions")
@RequiredArgsConstructor
public class DivisionController {

    private final DivisionService divisionService;

    // ==========================================
    // TEST API
    // ==========================================
    @GetMapping("/test")
    public String test() {
        return "Division Controller Working";
    }

    // ==========================================
    // CREATE DIVISION
    // ==========================================
    @PostMapping
    @PreAuthorize("hasRole('SUPER_ADMIN') or hasRole('ADMIN')")
    public ResponseEntity<DivisionResponse> create(
            @Valid @RequestBody DivisionRequest request) {

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(divisionService.create(request));
    }

    // ==========================================
    // GET DIVISION BY ID
    // ==========================================
    @GetMapping("/{id}")
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<DivisionResponse> getById(
            @PathVariable UUID id) {

        return ResponseEntity.ok(
                divisionService.getById(id)
        );
    }

    // ==========================================
    // GET ALL DIVISIONS
    // ==========================================
    @GetMapping
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<List<DivisionResponse>> getAll() {

        return ResponseEntity.ok(
                divisionService.getAll()
        );
    }

    // ==========================================
    // GET DIVISIONS BY BUSINESS UNIT
    // ==========================================
    @GetMapping("/business-unit/{businessUnitId}")
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<List<DivisionResponse>> getByBusinessUnit(
            @PathVariable UUID businessUnitId) {

        return ResponseEntity.ok(
                divisionService.getByBusinessUnit(businessUnitId)
        );
    }

    // ==========================================
    // UPDATE DIVISION
    // ==========================================
    @PutMapping("/{id}")
    @PreAuthorize("hasRole('SUPER_ADMIN') or hasRole('ADMIN')")
    public ResponseEntity<DivisionResponse> update(
            @PathVariable UUID id,
            @Valid @RequestBody DivisionRequest request) {

        return ResponseEntity.ok(
                divisionService.update(id, request)
        );
    }

    // ==========================================
    // DELETE DIVISION
    // ==========================================
    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('SUPER_ADMIN')")
    public ResponseEntity<Void> delete(
            @PathVariable UUID id) {

        divisionService.delete(id);

        return ResponseEntity.noContent().build();
    }
}
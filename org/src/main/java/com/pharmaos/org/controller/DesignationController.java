package com.pharmaos.org.controller;

import com.pharmaos.org.dto.DesignationRequest;
import com.pharmaos.org.dto.DesignationResponse;
import com.pharmaos.org.service.DesignationService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/designations")
@RequiredArgsConstructor
public class DesignationController {

    private final DesignationService designationService;

    @GetMapping("/test")
    public String test() {
        return "Designation Controller Working";
    }

    @PostMapping
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<DesignationResponse> create(
            @Valid @RequestBody DesignationRequest request) {

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(designationService.create(request));
    }

    @GetMapping
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<List<DesignationResponse>> getAll() {

        return ResponseEntity.ok(designationService.getAll());
    }

    @GetMapping("/{id}")
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<DesignationResponse> getById(
            @PathVariable UUID id) {

        return ResponseEntity.ok(
                designationService.getById(id));
    }

    @PutMapping("/{id}")
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<DesignationResponse> update(
            @PathVariable UUID id,
            @Valid @RequestBody DesignationRequest request) {

        return ResponseEntity.ok(
                designationService.update(id, request));
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<Void> delete(
            @PathVariable UUID id) {

        designationService.delete(id);

        return ResponseEntity.noContent().build();
    }
}
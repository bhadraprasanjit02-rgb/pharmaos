package com.pharmaos.org.controller;

import com.pharmaos.org.dto.RegionRequest;
import com.pharmaos.org.dto.RegionResponse;
import com.pharmaos.org.service.RegionService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/regions")
@RequiredArgsConstructor
public class RegionController {

    private final RegionService regionService;

    @GetMapping("/test")
    public String test() {
        return "Region Controller Working";
    }

    @PostMapping
    @PreAuthorize("hasRole('SUPER_ADMIN') or hasRole('ADMIN')")
    public ResponseEntity<RegionResponse> create(
            @Valid @RequestBody RegionRequest request) {

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(regionService.create(request));
    }

    @GetMapping
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<List<RegionResponse>> getAll() {
        return ResponseEntity.ok(regionService.getAll());
    }

    @GetMapping("/{id}")
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<RegionResponse> getById(@PathVariable UUID id) {
        return ResponseEntity.ok(regionService.getById(id));
    }

    @GetMapping("/division/{divisionId}")
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<List<RegionResponse>> getByDivision(
            @PathVariable UUID divisionId) {

        return ResponseEntity.ok(
                regionService.getByDivision(divisionId));
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('SUPER_ADMIN') or hasRole('ADMIN')")
    public ResponseEntity<RegionResponse> update(
            @PathVariable UUID id,
            @Valid @RequestBody RegionRequest request) {

        return ResponseEntity.ok(
                regionService.update(id, request));
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('SUPER_ADMIN')")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {

        regionService.delete(id);

        return ResponseEntity.noContent().build();
    }
}
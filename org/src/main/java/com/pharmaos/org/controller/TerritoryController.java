package com.pharmaos.org.controller;

import com.pharmaos.org.dto.TerritoryRequest;
import com.pharmaos.org.dto.TerritoryResponse;
import com.pharmaos.org.service.TerritoryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/territories")
@RequiredArgsConstructor
public class TerritoryController {

    private final TerritoryService territoryService;

    @GetMapping("/test")
    public String test() {
        return "Territory Controller Working";
    }

    @PostMapping
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<TerritoryResponse> create(
            @Valid @RequestBody TerritoryRequest request) {

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(territoryService.create(request));
    }

    @GetMapping
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<List<TerritoryResponse>> getAll() {
        return ResponseEntity.ok(territoryService.getAll());
    }

    @GetMapping("/{id}")
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<TerritoryResponse> getById(
            @PathVariable UUID id) {

        return ResponseEntity.ok(
                territoryService.getById(id));
    }

    @GetMapping("/region/{regionId}")
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<List<TerritoryResponse>> getByRegion(
            @PathVariable UUID regionId) {

        return ResponseEntity.ok(
                territoryService.getByRegion(regionId));
    }

    @PutMapping("/{id}")
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<TerritoryResponse> update(
            @PathVariable UUID id,
            @Valid @RequestBody TerritoryRequest request) {

        return ResponseEntity.ok(
                territoryService.update(id, request));
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<Void> delete(
            @PathVariable UUID id) {

        territoryService.delete(id);

        return ResponseEntity.noContent().build();
    }
}
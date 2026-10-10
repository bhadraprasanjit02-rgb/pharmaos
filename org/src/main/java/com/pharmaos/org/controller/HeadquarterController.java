package com.pharmaos.org.controller;

import com.pharmaos.org.dto.HeadquarterRequest;
import com.pharmaos.org.dto.HeadquarterResponse;
import com.pharmaos.org.service.HeadquarterService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/headquarters")
@RequiredArgsConstructor
public class HeadquarterController {

    private final HeadquarterService headquarterService;

    @GetMapping("/test")
    public String test() {
        return "Headquarter Controller Working";
    }

    @PostMapping
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<HeadquarterResponse> create(
            @Valid @RequestBody HeadquarterRequest request) {

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(headquarterService.create(request));
    }

    @GetMapping
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<List<HeadquarterResponse>> getAll() {

        return ResponseEntity.ok(
                headquarterService.getAll());
    }

    @GetMapping("/{id}")
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<HeadquarterResponse> getById(
            @PathVariable UUID id) {

        return ResponseEntity.ok(
                headquarterService.getById(id));
    }

    @GetMapping("/territory/{territoryId}")
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<List<HeadquarterResponse>> getByTerritory(
            @PathVariable UUID territoryId) {

        return ResponseEntity.ok(
                headquarterService.getByTerritory(territoryId));
    }

    @PutMapping("/{id}")
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<HeadquarterResponse> update(
            @PathVariable UUID id,
            @Valid @RequestBody HeadquarterRequest request) {

        return ResponseEntity.ok(
                headquarterService.update(id, request));
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<Void> delete(
            @PathVariable UUID id) {

        headquarterService.delete(id);

        return ResponseEntity.noContent().build();
    }
}
package com.pharmaos.org.controller;

import com.pharmaos.org.dto.EmployeeRequest;
import com.pharmaos.org.dto.EmployeeResponse;
import com.pharmaos.org.service.EmployeeService;

import jakarta.validation.Valid;

import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/employees")
@RequiredArgsConstructor
public class EmployeeController {
    private final EmployeeService employeeService;
    @PostMapping
public ResponseEntity<EmployeeResponse> create(
        @Valid @RequestBody EmployeeRequest request) {

    EmployeeResponse response = employeeService.create(request);

    return ResponseEntity.status(HttpStatus.CREATED)
            .body(response);
}
@PutMapping("/{id}")
public ResponseEntity<EmployeeResponse> update(
        @PathVariable UUID id,
        @Valid @RequestBody EmployeeRequest request) {

    return ResponseEntity.ok(
            employeeService.update(id, request));
}
@GetMapping("/{id}")
public ResponseEntity<EmployeeResponse> getById(
        @PathVariable UUID id) {

    return ResponseEntity.ok(
            employeeService.getById(id));
}
@GetMapping
public ResponseEntity<List<EmployeeResponse>> getAll() {

    return ResponseEntity.ok(
            employeeService.getAll());
}
@GetMapping("/headquarter/{headquarterId}")
public ResponseEntity<List<EmployeeResponse>> getByHeadquarter(
        @PathVariable UUID headquarterId) {

    return ResponseEntity.ok(
            employeeService.getByHeadquarter(headquarterId));
}
@GetMapping("/manager/{managerId}")
public ResponseEntity<List<EmployeeResponse>> getByReportingManager(
        @PathVariable UUID managerId) {

    return ResponseEntity.ok(
            employeeService.getByReportingManager(managerId));
}
@DeleteMapping("/{id}")
public ResponseEntity<Void> delete(
        @PathVariable UUID id) {

    employeeService.delete(id);

    return ResponseEntity.noContent().build();
}
}
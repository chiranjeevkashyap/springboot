package com.chiranjeevkashyap.springboot.controllers;

import com.chiranjeevkashyap.springboot.dto.EmployeeDTO;
import com.chiranjeevkashyap.springboot.services.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "employees")
public class EmployeeController {
    private final EmployeeService service;

    public EmployeeController(EmployeeService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<EmployeeDTO>> findAll() {
        List<EmployeeDTO> employees = service.findAll();
        return employees.isEmpty() ? ResponseEntity.notFound().build() : ResponseEntity.ok(employees);
    }

    @GetMapping(path = "{employeeId}")
    public ResponseEntity<EmployeeDTO> getEmployee(@PathVariable(name = "employeeId") Long id) {
        return service.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<EmployeeDTO> save(@RequestBody @Valid EmployeeDTO employeeEntity) {
        return new ResponseEntity<>(service.save(employeeEntity), HttpStatus.CREATED);
    }

    @PutMapping(path = "{employeeId}")
    public ResponseEntity<EmployeeDTO> updateEmployee(@PathVariable(name = "employeeId") Long id, @RequestBody @Valid EmployeeDTO employeeDTO) {
        return ResponseEntity.ok(service.updateEmployee(id, employeeDTO));
    }

    @DeleteMapping(path = "{employeeId}")
    public ResponseEntity<Boolean> deleteEmployee(@PathVariable(name = "employeeId") Long id) {
        boolean gotDeleted = service.deleteEmployee(id);
        if (gotDeleted) return ResponseEntity.ok(true);
        return ResponseEntity.notFound().build();
    }

    @PatchMapping(path = "{employeeId}")
    public ResponseEntity<EmployeeDTO> updatePartialEmployee(@PathVariable(name = "employeeId") Long id, @RequestBody Map<String, Object> updates) {
        EmployeeDTO employeeDTO = service.updatePartialEmployee(id, updates);
        if (employeeDTO == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(employeeDTO);
    }
}

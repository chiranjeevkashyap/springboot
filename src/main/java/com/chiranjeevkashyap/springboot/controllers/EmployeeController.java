package com.chiranjeevkashyap.springboot.controllers;

import com.chiranjeevkashyap.springboot.dto.EmployeeDTO;
import com.chiranjeevkashyap.springboot.services.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "employees")
public class EmployeeController {
    private final EmployeeService service;

    public EmployeeController(EmployeeService service) {
        this.service = service;
    }

    @GetMapping
    public List<EmployeeDTO> findAll() {
        return service.findAll();
    }

    @GetMapping(path = "{employeeId}")
    public EmployeeDTO getEmployee(@PathVariable(name = "employeeId") Long id) {
        return service.findById(id);
    }

    @PostMapping
    public EmployeeDTO save(@RequestBody EmployeeDTO employeeEntity) {
        return service.save(employeeEntity);
    }
}

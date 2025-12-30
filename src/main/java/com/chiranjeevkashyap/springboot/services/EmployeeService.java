package com.chiranjeevkashyap.springboot.services;

import com.chiranjeevkashyap.springboot.dto.EmployeeDTO;
import com.chiranjeevkashyap.springboot.entities.Employee;
import com.chiranjeevkashyap.springboot.exceptions.ResourceNotFoundException;
import com.chiranjeevkashyap.springboot.repositories.EmployeeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmployeeService {
    private final EmployeeRepository repository;
    private final ModelMapper mapper;

    public EmployeeService(EmployeeRepository repository, ModelMapper modelMapper) {
        this.repository = repository;
        this.mapper = modelMapper;
    }

    public List<EmployeeDTO> findAll() {
        List<Employee> employeeEntities = repository.findAll();
        return employeeEntities
                .stream()
                .map(employee -> mapper.map(employee, EmployeeDTO.class))
                .collect(Collectors.toList());
    }

    public Optional<EmployeeDTO> findById(Long id) {
        isEmployeeExists(id);
        return repository.findById(id).map(employee -> mapper.map(employee, EmployeeDTO.class));
    }

    public EmployeeDTO save(EmployeeDTO employeeDTO) {
        Employee employee = mapper.map(employeeDTO, Employee.class);
        return mapper.map(repository.save(employee), EmployeeDTO.class);
    }

    public EmployeeDTO updateEmployee(Long id, EmployeeDTO employeeDTO) {
        Employee employee = mapper.map(employeeDTO, Employee.class);
        isEmployeeExists(id);
        employee.setId(id);
        return mapper.map(repository.save(employee), EmployeeDTO.class);
    }

    public boolean deleteEmployee(Long id) {
        isEmployeeExists(id);
        repository.deleteById(id);
        return true;
    }

    public EmployeeDTO updatePartialEmployee(Long id, Map<String, Object> updates) {
        isEmployeeExists(id);
        Employee employee = repository.findById(id).get();
        updates.forEach((field, value) -> {
            System.out.println("Updating field: " + field + " with value: " + value);
            Field fieldToBeUpdated = ReflectionUtils.findField(Employee.class, field);
            if (fieldToBeUpdated != null) {
                fieldToBeUpdated.setAccessible(true);
                ReflectionUtils.setField(fieldToBeUpdated, employee, value);
            }
        });
        Employee savedEntity = repository.save(employee);
        return mapper.map(savedEntity, EmployeeDTO.class);
    }

    private void isEmployeeExists(Long id) {
        boolean isExists = repository.existsById(id);
        if (!isExists) throw new ResourceNotFoundException("Employee not found with id: " + id);
    }
}

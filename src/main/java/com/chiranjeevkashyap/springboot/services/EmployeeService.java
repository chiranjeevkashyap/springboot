package com.chiranjeevkashyap.springboot.services;

import com.chiranjeevkashyap.springboot.dto.EmployeeDTO;
import com.chiranjeevkashyap.springboot.entities.EmployeeEntity;
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
        List<EmployeeEntity> employeeEntities = repository.findAll();
        return employeeEntities
                .stream()
                .map(employeeEntity -> mapper.map(employeeEntity, EmployeeDTO.class))
                .collect(Collectors.toList());
    }

    public Optional<EmployeeDTO> findById(Long id) {
        return repository.findById(id).map(employee -> mapper.map(employee, EmployeeDTO.class));
    }

    public EmployeeDTO save(EmployeeDTO employeeDTO) {
        EmployeeEntity employeeEntity = mapper.map(employeeDTO, EmployeeEntity.class);
        return mapper.map(repository.save(employeeEntity), EmployeeDTO.class);
    }

    public EmployeeDTO updateEmployee(Long id, EmployeeDTO employeeDTO) {
        EmployeeEntity employeeEntity = mapper.map(employeeDTO, EmployeeEntity.class);
        employeeEntity.setId(id);
        return mapper.map(repository.save(employeeEntity), EmployeeDTO.class);
    }

    public boolean deleteEmployee(Long id) {
        boolean exists = isEmployeeExists(id);
        if (!exists) return false;
        repository.deleteById(id);
        return true;
    }

    public EmployeeDTO updatePartialEmployee(Long id, Map<String, Object> updates) {
        EmployeeEntity employeeEntity = repository.findById(id).orElse(null);
        if (employeeEntity == null) return null;
        updates.forEach((field, value) -> {
            System.out.println("Updating field: " + field + " with value: " + value);
            Field fieldToBeUpdated = ReflectionUtils.findField(EmployeeEntity.class, field);
            if (fieldToBeUpdated != null) {
                fieldToBeUpdated.setAccessible(true);
                ReflectionUtils.setField(fieldToBeUpdated, employeeEntity, value);
            }
        });
        EmployeeEntity savedEntity = repository.save(employeeEntity);
        return mapper.map(savedEntity, EmployeeDTO.class);
    }

    private boolean isEmployeeExists(Long id) {
        return repository.existsById(id);
    }
}

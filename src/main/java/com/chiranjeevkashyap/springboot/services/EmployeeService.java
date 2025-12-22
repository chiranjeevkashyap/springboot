package com.chiranjeevkashyap.springboot.services;

import com.chiranjeevkashyap.springboot.dto.EmployeeDTO;
import com.chiranjeevkashyap.springboot.entities.EmployeeEntity;
import com.chiranjeevkashyap.springboot.repositories.EmployeeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeService {
    private final EmployeeRepository repository;
    private final ModelMapper modelMapper;

    public EmployeeService(EmployeeRepository repository, ModelMapper modelMapper) {
        this.repository = repository;
        this.modelMapper = modelMapper;
    }

    public List<EmployeeDTO> findAll() {
        List<EmployeeEntity> employeeEntities = repository.findAll();
        return employeeEntities
                .stream()
                .map(employeeEntity -> modelMapper.map(employeeEntity, EmployeeDTO.class))
                .collect(Collectors.toList());
    }

    public EmployeeDTO findById(Long id) {
        EmployeeEntity employeeEntity = repository.findById(id).orElse(null);
        return modelMapper.map(employeeEntity, EmployeeDTO.class);
    }

    public EmployeeDTO save(EmployeeDTO employeeDTO) {
        EmployeeEntity employeeEntity = modelMapper.map(employeeDTO, EmployeeEntity.class);
        return modelMapper.map(repository.save(employeeEntity), EmployeeDTO.class);
    }
}

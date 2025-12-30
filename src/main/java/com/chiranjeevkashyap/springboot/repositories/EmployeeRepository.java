package com.chiranjeevkashyap.springboot.repositories;

import com.chiranjeevkashyap.springboot.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}

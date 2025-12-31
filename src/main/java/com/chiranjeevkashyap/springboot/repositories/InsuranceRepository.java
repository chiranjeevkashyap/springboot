package com.chiranjeevkashyap.springboot.repositories;

import com.chiranjeevkashyap.springboot.entities.Insurance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InsuranceRepository extends JpaRepository<Insurance, Long> {
}
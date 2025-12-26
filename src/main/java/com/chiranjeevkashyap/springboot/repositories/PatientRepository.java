package com.chiranjeevkashyap.springboot.repositories;

import com.chiranjeevkashyap.springboot.dto.PatientInfo;
import com.chiranjeevkashyap.springboot.dto.PatientInfoConcrete;
import com.chiranjeevkashyap.springboot.entities.PatientEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PatientRepository extends JpaRepository<PatientEntity, Long> {
    @Query("select p.id as id, p.name as name, p.email as email from PatientEntity p")
    List<PatientInfo> getAllPatientsInfo();

    @Query("select new com.chiranjeevkashyap.springboot.dto.PatientInfoConcrete(p.id, p.name) from PatientEntity p")
    List<PatientInfoConcrete> getAllPatientInfoConcrete();
}

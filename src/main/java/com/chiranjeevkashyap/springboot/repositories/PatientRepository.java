package com.chiranjeevkashyap.springboot.repositories;

import com.chiranjeevkashyap.springboot.dto.PatientInfo;
import com.chiranjeevkashyap.springboot.dto.PatientInfoConcrete;
import com.chiranjeevkashyap.springboot.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PatientRepository extends JpaRepository<Patient, Long> {
    @Query("select p.id as id, p.name as name, p.email as email from Patient p")
    List<PatientInfo> getAllPatientsInfo();

    @Query("select new com.chiranjeevkashyap.springboot.dto.PatientInfoConcrete(p.id, p.name) from Patient p")
    List<PatientInfoConcrete> getAllPatientInfoConcrete();
}

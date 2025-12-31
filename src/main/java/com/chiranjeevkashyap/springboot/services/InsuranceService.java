package com.chiranjeevkashyap.springboot.services;

import com.chiranjeevkashyap.springboot.entities.Insurance;
import com.chiranjeevkashyap.springboot.entities.Patient;
import com.chiranjeevkashyap.springboot.repositories.InsuranceRepository;
import com.chiranjeevkashyap.springboot.repositories.PatientRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InsuranceService {
    private final InsuranceRepository insuranceRepository;
    private final PatientRepository patientRepository;

    @Transactional
    public Insurance mapInsuranceToPatient(Insurance insurance, Long patientId) {
        Patient patient = patientRepository.findById(patientId).orElseThrow();
        patient.setInsurance(insurance);
        insurance.setPatient(patient);
        return insurance;
    }

    @Transactional
    public void deletePatient(Long patientId) {
        patientRepository.findById(patientId);
        patientRepository.deleteById(patientId);
    }
}

package com.chiranjeevkashyap.springboot.services;

import com.chiranjeevkashyap.springboot.repositories.PatientRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PatientService {
    private final PatientRepository patientRepository;

    @Transactional
    public void deletePatient(Long patientId) {
        patientRepository.findById(patientId);
        patientRepository.deleteById(patientId);
    }
}

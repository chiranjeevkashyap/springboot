package com.chiranjeevkashyap.springboot;

import com.chiranjeevkashyap.springboot.repositories.PatientRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class PatientTests {
    @Autowired
    private PatientRepository patientRepository;

    @Test
    void test() {
        /*patientRepository.findAll().forEach(System.out::println);*/
        /*patientRepository.getAllPatientsInfo().forEach(System.out::println);*/
        patientRepository.getAllPatientInfoConcrete().forEach(System.out::println);
    }
}

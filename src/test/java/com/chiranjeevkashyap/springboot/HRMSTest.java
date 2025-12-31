package com.chiranjeevkashyap.springboot;

import com.chiranjeevkashyap.springboot.entities.Appointment;
import com.chiranjeevkashyap.springboot.entities.Insurance;
import com.chiranjeevkashyap.springboot.services.AppointmentService;
import com.chiranjeevkashyap.springboot.services.InsuranceService;
import com.chiranjeevkashyap.springboot.services.PatientService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.LocalDateTime;

@SpringBootTest
public class HRMSTest {
    @Autowired
    private InsuranceService insuranceService;

    @Autowired
    private AppointmentService appointmentService;

    @Autowired
    private PatientService patientService;

    @Test
    public void test() {
        Insurance insurance = Insurance.builder()
                .provider("HDFC")
                .policyNumber("HDFC_23GOLD")
                .validUntil(LocalDate.of(2026, 3, 31))
                .build();
        Insurance updatedInsurance = insuranceService.mapInsuranceToPatient(insurance, 1L);
        System.out.println(updatedInsurance);
        insuranceService.deletePatient(1L);
    }

    @Test
    public void testTakeAppointment() {
        Appointment appointment = Appointment.builder()
                .appointmentTime(LocalDateTime.of(2025, 1, 1, 8, 0, 0))
                .reason("Cold")
                .build();
        Appointment takedAppointment = appointmentService.takeAppointment(appointment, 1L, 1L);
        System.out.println(takedAppointment);
        patientService.deletePatient(1L);
    }
}

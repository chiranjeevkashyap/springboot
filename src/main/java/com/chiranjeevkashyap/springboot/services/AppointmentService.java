package com.chiranjeevkashyap.springboot.services;

import com.chiranjeevkashyap.springboot.entities.Appointment;
import com.chiranjeevkashyap.springboot.entities.Doctor;
import com.chiranjeevkashyap.springboot.entities.Patient;
import com.chiranjeevkashyap.springboot.repositories.AppointmentRepository;
import com.chiranjeevkashyap.springboot.repositories.DoctorRepository;
import com.chiranjeevkashyap.springboot.repositories.PatientRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AppointmentService {
    private final AppointmentRepository appointmentRepository;
    private final DoctorRepository doctorRepository;
    private final PatientRepository patientRepository;

    @Transactional
    public Appointment takeAppointment(Appointment appointment, Long patientId, Long doctorId) {
        Patient patient = patientRepository.findById(patientId).orElseThrow();
        Doctor doctor = doctorRepository.findById(doctorId).orElseThrow();
        appointment.setPatient(patient);
        appointment.setDoctor(doctor);
        appointmentRepository.save(appointment);
        return appointment;
    }
}

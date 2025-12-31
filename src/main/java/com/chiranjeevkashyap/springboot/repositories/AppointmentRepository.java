package com.chiranjeevkashyap.springboot.repositories;

import com.chiranjeevkashyap.springboot.entities.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
}
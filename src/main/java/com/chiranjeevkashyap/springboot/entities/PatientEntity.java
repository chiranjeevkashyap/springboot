package com.chiranjeevkashyap.springboot.entities;

import com.chiranjeevkashyap.springboot.entities.types.BloodGroup;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "patients")
public class PatientEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private LocalDate dateOfBirth;
    private String email;
    private String gender;
    @Enumerated(value = EnumType.STRING)
    private BloodGroup bloodGroup;
    @CreationTimestamp
    private LocalDateTime createdAt;
}

package com.chiranjeevkashyap.springboot.entities;

import com.chiranjeevkashyap.springboot.entities.types.BloodGroup;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "patients")
@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Patient {
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

    @OneToOne()
    @JoinColumn(unique = true)
    private Insurance insurance;

    @OneToMany(mappedBy = "patient") // inverse side relation
    private Set<Appointment> appointments = new HashSet<>();
}

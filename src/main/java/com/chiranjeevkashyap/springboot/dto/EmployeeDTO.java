package com.chiranjeevkashyap.springboot.dto;

import com.chiranjeevkashyap.springboot.annotations.EmployeeRoleValidation;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDTO {
    private Long id;

    @NotBlank(message = "Required field in Employee: name")
    @Size(min = 3, max = 25, message = "Invalid name length: [3, 25]")
    private String name;

    @NotBlank(message = "Required field in Employee: email")
    @Email(message = "Provide valid email")
    private String email;

    @NotNull(message = "Required field in Employee: age")
    @Min(value = 18, message = "Age should be greater & equal than 18")
    @Max(value = 80, message = "Age should be below & equal than 80")
    private Integer age;

    @NotBlank(message = "Required field in Employee: Role")
    // @Pattern(regexp = "^(ADMIN|USER)$", message = "Role of employee can be ADMIN or USER")
    @EmployeeRoleValidation
    private String role;

    @NotNull(message = "Required field in Employee: dateOfJoining")
    @PastOrPresent(message = "Date of Joining, cannot be in future")
    private LocalDate dateOfJoining;

    @NotNull(message = "Salary of employee should be not null")
    @Positive(message = "Salary of employee should be positive")
    @Digits(integer = 6, fraction = 2, message = "The salary can be in form XXXXXX:YY")
    @DecimalMin(value = "100.50")
    @DecimalMax(value = "100000.99")
    private Double salary;

    @JsonProperty("isActive")
    @AssertTrue(message = "Employee should be active")
    private boolean isActive;
}

package com.chiranjeevkashyap.springboot;

import com.chiranjeevkashyap.springboot.repositories.EmployeeRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class EmployeeTest {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Test
    void test() {
        //
    }
}

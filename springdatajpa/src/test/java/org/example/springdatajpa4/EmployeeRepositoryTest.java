package org.example.springdatajpa4;

import org.example.springdatajpa3.Application;
import org.example.springdatajpa4.Employee;
import org.example.springdatajpa4.EmployeeRepository;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class EmployeeRepositoryTest {
    private static final Logger log = LoggerFactory.getLogger(EmployeeRepository.class);

    @Autowired
    EmployeeRepository employeeRepository;

    @Test
    void findByLastName() {
        List<Employee> findByLastName = employeeRepository.findByLastName("king");
        findByLastName.forEach(employee -> log.info(findByLastName.getLast().getFirstName()));

    }
}
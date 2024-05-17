package com.bicaksiz.employeeservice.repository;

import com.bicaksiz.employeeservice.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}

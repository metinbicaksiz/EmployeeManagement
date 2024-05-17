package com.bicaksiz.employeeservice.service;

import com.bicaksiz.employeeservice.dto.EmployeeDto;

public interface EmployeeService {

    EmployeeDto saveEmployee(EmployeeDto employeeDto);

    EmployeeDto getEmployeeById(Long employeeId);
}

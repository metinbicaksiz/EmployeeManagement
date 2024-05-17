package com.bicaksiz.employeeservice.service.impl;

import com.bicaksiz.employeeservice.dto.EmployeeDto;
import com.bicaksiz.employeeservice.entity.Employee;
import com.bicaksiz.employeeservice.repository.EmployeeRepository;
import com.bicaksiz.employeeservice.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

    private ModelMapper modelMapper;

    @Override
    public EmployeeDto saveEmployee(EmployeeDto employeeDto) {
        Employee employee = modelMapper.map(employeeDto, Employee.class);
        Employee savedEmployee = employeeRepository.save(employee);

        return new EmployeeDto(
                savedEmployee.getId(),
                savedEmployee.getFirstName(),
                savedEmployee.getLastName(),
                savedEmployee.getEmail()
        );
    }

    @Override
    public EmployeeDto getEmployeeById(Long employeeId) {
        Optional<Employee> optionalEmployee = employeeRepository.findById(employeeId);
        Employee employee = optionalEmployee.orElse(null);

        return modelMapper.map(employee, EmployeeDto.class);
    }
}

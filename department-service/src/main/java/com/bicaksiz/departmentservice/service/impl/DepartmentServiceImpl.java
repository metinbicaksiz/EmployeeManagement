package com.bicaksiz.departmentservice.service.impl;

import com.bicaksiz.departmentservice.dto.DepartmentDto;
import com.bicaksiz.departmentservice.entity.Department;
import com.bicaksiz.departmentservice.repository.DepartmentRepository;
import com.bicaksiz.departmentservice.service.DepartmentService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

    private DepartmentRepository departmentRepository;

    private ModelMapper modelMapper;

    @Override
    public DepartmentDto saveDepartment(DepartmentDto departmentDto) {
        Department department = modelMapper.map(departmentDto, Department.class);
        Department savedDepartment =  departmentRepository.save(department);

        return new DepartmentDto(
                savedDepartment.getId(),
                savedDepartment.getDepartmentName(),
                savedDepartment.getDepartmentDescription(),
                savedDepartment.getDepartmentCode()
        );
    }

    @Override
    public DepartmentDto getDepartmentByCode(String departmentCode) {
        Optional<Department> optionalDepartment = Optional.ofNullable(departmentRepository.findByDepartmentCode(departmentCode));
        Department department = optionalDepartment.get();
        return modelMapper.map(department, DepartmentDto.class);
    }
}

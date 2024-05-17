package com.bicaksiz.departmentservice.controller;

import com.bicaksiz.departmentservice.dto.DepartmentDto;
import com.bicaksiz.departmentservice.service.DepartmentService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/departments")
@AllArgsConstructor
public class DepartmentController {

    private DepartmentService departmentService;

    //Build Save department REST Api
    @PostMapping("create")
    public ResponseEntity<DepartmentDto> saveDepartment(@RequestBody DepartmentDto departmentDto) {
       DepartmentDto savedDepartment = departmentService.saveDepartment(departmentDto);
       return new ResponseEntity<>(savedDepartment, HttpStatus.CREATED);
    }

    // Build getDepartment REST Api
    @GetMapping("{department-code}")
    public ResponseEntity<DepartmentDto> getDepartment(@PathVariable("department-code") String departmentCode) {
       DepartmentDto departmentDto = departmentService.getDepartmentByCode(departmentCode);
       return new ResponseEntity<>(departmentDto, HttpStatus.OK);
    }
}

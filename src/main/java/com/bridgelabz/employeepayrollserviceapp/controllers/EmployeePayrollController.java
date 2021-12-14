package com.bridgelabz.employeepayrollserviceapp.controllers;

import com.bridgelabz.employeepayrollserviceapp.dto.EmployeePayrollDTO;
import com.bridgelabz.employeepayrollserviceapp.services.EmployeePayrollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/employee-payroll-service")
public class EmployeePayrollController {

    @Autowired
    private EmployeePayrollService employeePayrollService;

    @GetMapping(value = "/employee")
    public List<EmployeePayrollDTO> getAllEmployeeDetails() {
        return employeePayrollService.getEmployeePayrollList();
    }

    @PostMapping("/employee")
    public ResponseEntity<String> addEmployeePayrollData(
            @Valid @RequestBody EmployeePayrollDTO employeePayrollDTO
    ) {
        return new ResponseEntity<>(employeePayrollService.addEmployeeData(employeePayrollDTO), HttpStatus.OK);
    }

    @PutMapping("/employee")
    public ResponseEntity<String> updateEmployee(
            @RequestParam int id,
            @Valid @RequestBody EmployeePayrollDTO employeePayrollDTO
    ) {
        return new ResponseEntity<>(employeePayrollService.updateEmployeeDetails(id, employeePayrollDTO), HttpStatus.OK);

    }

    @DeleteMapping("/employee")
    public ResponseEntity<String> deleteEmployee(
            @RequestParam int id
    ) {
        return new ResponseEntity<>(employeePayrollService.deleteEmployee(id), HttpStatus.OK);
    }
}


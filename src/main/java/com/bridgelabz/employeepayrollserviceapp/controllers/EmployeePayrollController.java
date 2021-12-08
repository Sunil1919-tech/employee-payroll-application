package com.bridgelabz.employeepayrollserviceapp.controllers;

import com.bridgelabz.employeepayrollserviceapp.dto.EmployeePayrollDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employee-payroll-service")
public class EmployeePayrollController {

    @RequestMapping(value = {"", "/", "/get"})
    public ResponseEntity<String> getEmployeePayrollData() {
        return new ResponseEntity<String>(" Get Call Success", HttpStatus.OK);
    }

    @GetMapping("/employee/{empId}")
    public ResponseEntity<String> getEmployeePayrollData(
            @PathVariable("empId") int empId
    ) {
        return new ResponseEntity<String>(" Get Call Success for id:" + empId, HttpStatus.OK);
    }

    @PostMapping("/employee")
    public ResponseEntity<String> addEmployeePayrollData(
            @RequestBody EmployeePayrollDTO employeePayrollDTO
    ) {
        return new ResponseEntity<String>(" Created employee payroll Data for : " + employeePayrollDTO,
                HttpStatus.OK);
    }

    @PutMapping("/employee")
    public ResponseEntity<String> updateEmployeePayrollData(
            @RequestBody EmployeePayrollDTO employeePayrollDTO
    ) {
        return new ResponseEntity<String>(" Updated employee payroll data for: " + employeePayrollDTO, HttpStatus.OK);
    }

    @DeleteMapping("/employee/{empId}")
    public ResponseEntity<String> deleteEmployeeData(
            @PathVariable("empId") int empId
    ) {
        return new ResponseEntity<String>(" Updated employee payroll data for: " + empId, HttpStatus.OK);
    }
}


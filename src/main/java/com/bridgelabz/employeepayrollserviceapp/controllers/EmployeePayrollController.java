package com.bridgelabz.employeepayrollserviceapp.controllers;

import com.bridgelabz.employeepayrollserviceapp.dto.EmployeePayrollDTO;
import com.bridgelabz.employeepayrollserviceapp.dto.ResponseDTO;
import com.bridgelabz.employeepayrollserviceapp.entity.EmployeePayrollData;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employee-payroll-service")
public class EmployeePayrollController {

    @RequestMapping(value = {"", "/", "/get"})
    public ResponseEntity<ResponseDTO> getEmployeePayrollData() {
        EmployeePayrollData employeeData = null;
        employeeData = new EmployeePayrollData(1, new EmployeePayrollDTO("Sunil", 3000));
        ResponseDTO responseDTO = new ResponseDTO("Get Call successful", employeeData);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

    @GetMapping("/employee/{empId}")
    public ResponseEntity<ResponseDTO> getEmployeePayrollData(
            @PathVariable("empId") int empId
    ) {
        EmployeePayrollData employeeData = null;
        employeeData = new EmployeePayrollData(1, new EmployeePayrollDTO("Sunil", 3000));
        ResponseDTO responseDTO = new ResponseDTO("Get Call for ID successful", employeeData);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

    @PostMapping("/employee")
    public ResponseEntity<ResponseDTO> addEmployeePayrollData(
            @RequestBody EmployeePayrollDTO employeePayrollDTO
    ) {
        EmployeePayrollData employeeData = null;
        employeeData = new EmployeePayrollData(1, employeePayrollDTO);
        ResponseDTO responseDTO = new ResponseDTO("Created employee Payroll Data successfully", employeeData);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

    @PutMapping("/employee/{emp-id}")
    public ResponseEntity<ResponseDTO> updateEmployeePayrollData(
            @PathVariable("emp-id") int empId,
            @RequestBody EmployeePayrollDTO employeePayrollDTO
    ) {
        EmployeePayrollData employeeData = null;
        employeeData = new EmployeePayrollData(empId, employeePayrollDTO);
        ResponseDTO responseDTO = new ResponseDTO("Updated employee Payroll Data successfully", employeeData);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

    @DeleteMapping("/employee/{empId}")
    public ResponseEntity<ResponseDTO> deleteEmployeeData(
            @PathVariable("empId") int empId
    ) {
        ResponseDTO responseDTO = new ResponseDTO("Deleted Successfully", "Deleted id: " + empId);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }
}


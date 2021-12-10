package com.bridgelabz.employeepayrollserviceapp.controllers;

import com.bridgelabz.employeepayrollserviceapp.dto.EmployeePayrollDTO;
import com.bridgelabz.employeepayrollserviceapp.dto.ResponseDTO;
import com.bridgelabz.employeepayrollserviceapp.entity.EmployeePayrollDataEntity;
import com.bridgelabz.employeepayrollserviceapp.services.IEmployeePayrollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee-payroll-service")
public class EmployeePayrollController {

    @Autowired
    private IEmployeePayrollService employeePayrollService;

    @RequestMapping(value = {"", "/", "/get"})
    public ResponseEntity<ResponseDTO> getEmployeePayrollData() {
        List<EmployeePayrollDataEntity> employeeDataList = null;
        employeeDataList = employeePayrollService.getEmployeePayrolldata();
        ResponseDTO responseDTO = new ResponseDTO("Get Call successful", employeeDataList);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

    @GetMapping("/employee/{empId}")
    public ResponseEntity<ResponseDTO> getEmployeePayrollData(
            @PathVariable("empId") int empId
    ) {
        EmployeePayrollDataEntity employeePayrollData = employeePayrollService.getEmployeeDataById(empId);
        ResponseDTO responseDTO = new ResponseDTO("Get Call for ID successful", employeePayrollData);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

    @PostMapping("/employee")
    public ResponseEntity<ResponseDTO> addEmployeePayrollData(
            @RequestBody EmployeePayrollDTO employeePayrollDTO
    ) {
        EmployeePayrollDataEntity employeePayrollData = employeePayrollService.createEmployeePayrollData(employeePayrollDTO);
        ResponseDTO responseDTO = new ResponseDTO("Created employee Payroll Data successfully", employeePayrollData);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

    @PutMapping("/employee/{emp-id}")
    public ResponseEntity<ResponseDTO> updateEmployeePayrollData(
            @PathVariable("emp-id") int empId,
            @RequestBody EmployeePayrollDTO employeePayrollDTO
    ) {
        EmployeePayrollDataEntity employeePayrollData = null;
        employeePayrollData = employeePayrollService.updateEmployeePayrollData(empId, employeePayrollDTO);
        ResponseDTO responseDTO = new ResponseDTO("Updated employee Payroll Data successfully", employeePayrollData);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

    @DeleteMapping("/employee/{empId}")
    public ResponseEntity<ResponseDTO> deleteEmployeeData(
            @PathVariable("empId") int empId
    ) {
        employeePayrollService.deleteEmployeePayrollData(empId);
        ResponseDTO responseDTO = new ResponseDTO("Deleted Successfully", "Deleted id: " + empId);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }
}


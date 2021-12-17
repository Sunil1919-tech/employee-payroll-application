package com.bridgelabz.controller;

import com.bridgelabz.dto.EmployeePayrollDTO;
import com.bridgelabz.services.EmployeePayrollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Purpose: to perform the various http request from the client side
 *
 * @author Sunil
 * @version 0.0.1
 * @since 07/12/2021
 */

@RestController
@RequestMapping("/employee-payroll-service")
public class EmployeePayrollController {

    @Autowired
    private EmployeePayrollService employeePayrollService;

    /**
     * Purpose: Function to receive Get request method from the client
     *
     * @return : List of all employee Data from the database
     */
    @GetMapping(value = "/employee")
    public List<EmployeePayrollDTO> getAllEmployeeDetails() {
        return employeePayrollService.getEmployeePayrollList();
    }

    /**
     * Purpose: function to receive post request from client to add the Data
     * in the database
     *
     * @param employeePayrollDTO : employee data given from client end
     * @return : response entity newly created Data
     */
    @PostMapping("/employee")
    public ResponseEntity<String> addEmployeePayrollData(
            @Valid @RequestBody EmployeePayrollDTO employeePayrollDTO
    ) {
        return new ResponseEntity<>(employeePayrollService.addEmployeeData(employeePayrollDTO), HttpStatus.OK);
    }

    /**
     * Purpose: function to receive the Put request method from client to Update the Data
     * in the specified Database
     *
     * @param id:                 unique ID's of the employee
     * @param employeePayrollDTO: employee payroll input data from the client
     * @return: response entity ,updated data
     */
    @PutMapping("/employee/{id}")
    public ResponseEntity<String> updateEmployee(
            @PathVariable(value = "id") int id,
            @Valid @RequestBody EmployeePayrollDTO employeePayrollDTO
    ) {
        return new ResponseEntity<>(employeePayrollService.updateEmployeeDetails(id, employeePayrollDTO),
                HttpStatus.OK);

    }

    /**
     * Purpose: function to receive delete request method from the client side
     * to delete the already stored data from the database
     *
     * @param id: unique ID's of the employee
     * @return: response entity
     */
    @DeleteMapping("/employee/{id}")
    public ResponseEntity<String> deleteEmployee(
            @PathVariable(value = "id") int id
    ) {
        return new ResponseEntity<>(employeePayrollService.deleteEmployee(id), HttpStatus.OK);
    }

    /**
     * Purpose: function to request the data from the database using ID of the employee
     *
     * @param id: unique ID's of the employee
     * @return: response entity
     */
    @GetMapping(value = "/employee/{id}")
    public ResponseEntity<String> getDetailById(
            @PathVariable(value = "id") int id
    ) {
        EmployeePayrollDTO payrollDTO = employeePayrollService.getEmployeeByID(id);
        return new ResponseEntity(payrollDTO, HttpStatus.OK);
    }
}


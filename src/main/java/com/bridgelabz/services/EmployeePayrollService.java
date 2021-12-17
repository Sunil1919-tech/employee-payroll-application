package com.bridgelabz.services;

import com.bridgelabz.builder.EmployeePayrollBuilder;
import com.bridgelabz.dto.EmployeePayrollDTO;
import com.bridgelabz.entity.EmployeePayrollEntity;
import com.bridgelabz.exceptions.DataNotFoundException;
import com.bridgelabz.repository.EmployeePayrollRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;


/**
 * Purpose: the controller layer is to implement the business logics
 *
 * @author Sunil
 * @version 0.0.1
 * @since 07/12/2021
 */
@Service
@RestController
public class EmployeePayrollService {
    private static final String ADDED_EMPLOYEE = "Added Employee Details Successfully";
    private static final String DELETED_EMPLOYEE_DATA = "Deleted employee Details Successfully";
    private static final String EMPLOYEE_DETAILS_UPDATED = "Employee Details Updated Successfully";
    private static final String ID_INVALID = "Data not found Please try a Valid ID";


    @Autowired
    private EmployeePayrollRepository payrollRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private EmployeePayrollBuilder payrollBuilder;

    /**
     * Purpose: to get the list of all the Employee payroll system database
     *
     * @return : List of Data
     */
    public List<EmployeePayrollDTO> getEmployeePayrollList() {
        return payrollRepository
                .findAll()
                .stream()
                .map(employeePayrollEntity ->
                        modelMapper.map(employeePayrollEntity, EmployeePayrollDTO.class))
                .collect(Collectors.toList());
    }

    /**
     * Purpose: Method to add the employee details into the database
     *
     * @param employeePayrollDTO input entry details from the client
     * @return: successful message
     */
    public String addEmployeeData(EmployeePayrollDTO employeePayrollDTO) {
        EmployeePayrollEntity employeePayrollEntity = modelMapper.map(employeePayrollDTO, EmployeePayrollEntity.class);
        payrollRepository.save(employeePayrollEntity);
        return ADDED_EMPLOYEE;
    }

    /**
     * Purpose: method to update the database of employee Payroll By ID
     *
     * @param id                 unique ID's of the employee
     * @param employeePayrollDTO input entry fields from client
     * @return success message
     */
    public String updateEmployeeDetails(int id, EmployeePayrollDTO employeePayrollDTO) {
        EmployeePayrollEntity employeePayrollEntity = findByEmployeeId(id);
        EmployeePayrollEntity payrollEntity = payrollBuilder.buildPayrollEntity(employeePayrollDTO, employeePayrollEntity);
        payrollRepository.save(payrollEntity);
        return EMPLOYEE_DETAILS_UPDATED;
    }

    /**
     * Purpose: Method to delete the data from the database of employee payroll by ID
     *
     * @param id unique ID's of the employee
     * @return success message
     */
    public String deleteEmployee(int id) {
        EmployeePayrollEntity employeePayrollEntity = findByEmployeeId(id);
        payrollRepository.delete(employeePayrollEntity);
        return DELETED_EMPLOYEE_DATA;
    }

    private EmployeePayrollEntity findByEmployeeId(int id) {
        return payrollRepository.findById(id).orElseThrow(() -> new DataNotFoundException(ID_INVALID));
    }

    /**
     * Purpose: Method to find the data by using ID from the database
     *
     * @param id unique ID's of the employee
     * @return data with the specified ID
     */
    public EmployeePayrollDTO getEmployeeByID(int id) {
        EmployeePayrollEntity employeePayrollEntity = findByEmployeeId(id);
        return modelMapper.map(employeePayrollEntity, EmployeePayrollDTO.class);
    }
}

package com.bridgelabz.employeepayrollserviceapp.services;

import com.bridgelabz.employeepayrollserviceapp.builder.EmployeePayrollBuilder;
import com.bridgelabz.employeepayrollserviceapp.dto.EmployeePayrollDTO;
import com.bridgelabz.employeepayrollserviceapp.entity.EmployeePayrollEntity;
import com.bridgelabz.employeepayrollserviceapp.exceptions.DataNotFoundException;
import com.bridgelabz.employeepayrollserviceapp.repository.EmployeePayrollRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RestController
public class EmployeePayrollService {
    private static final String ADDED_EMPLOYEE = "Added Employee Details Successfully";
    private static final String DELETED_EPLOYEE_DATA = "Deleted employee Details Successfully";
    private static final String EMPLOYEE_DETAILS_UPDATED = "Employee Details Updated Successfully";
    private static final String ID_INVALID = "Data not found Please try a Valid ID";


    @Autowired
    private EmployeePayrollRepository payrollRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private EmployeePayrollBuilder payrollBuilder;

    public List<EmployeePayrollDTO> getEmployeePayrollList() {
        return payrollRepository
                .findAll()
                .stream()
                .map(employeePayrollEntity ->
                        modelMapper.map(employeePayrollEntity, EmployeePayrollDTO.class))
                .collect(Collectors.toList());
    }

    public String addEmployeeData(EmployeePayrollDTO employeePayrollDTO) {
        EmployeePayrollEntity employeePayrollEntity = modelMapper.map(employeePayrollDTO, EmployeePayrollEntity.class);
        payrollRepository.save(employeePayrollEntity);
        return ADDED_EMPLOYEE;
    }

    public String updateEmployeeDetails(int id, EmployeePayrollDTO employeePayrollDTO) {
        EmployeePayrollEntity employeePayrollEntity = findByEmployeeId(id);
        EmployeePayrollEntity payrollEntity = payrollBuilder.buildPayrollEntity(employeePayrollDTO, employeePayrollEntity);
        payrollRepository.save(payrollEntity);
        return EMPLOYEE_DETAILS_UPDATED;
    }

    public String deleteEmployee(int id) {
        EmployeePayrollEntity employeePayrollEntity = findByEmployeeId(id);
        payrollRepository.delete(employeePayrollEntity);
        return DELETED_EPLOYEE_DATA;
    }

    private EmployeePayrollEntity findByEmployeeId(int id) {
        return payrollRepository.findById(id).orElseThrow(() -> new DataNotFoundException(ID_INVALID));
    }


    public EmployeePayrollDTO getEmployeeByID(int id) {
        EmployeePayrollEntity employeePayrollEntity = findByEmployeeId(id);
        return modelMapper.map(employeePayrollEntity, EmployeePayrollDTO.class);
    }
}

package com.bridgelabz.employeepayrollserviceapp.builder;

import com.bridgelabz.employeepayrollserviceapp.dto.EmployeePayrollDTO;
import com.bridgelabz.employeepayrollserviceapp.entity.EmployeePayrollEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EmployeePayrollBuilder {

    @Autowired
    private ModelMapper modelMapper;

    public EmployeePayrollEntity buildPayrollEntity(EmployeePayrollDTO employeePayrollDTO, EmployeePayrollEntity payrollEntity) {
        modelMapper.map( employeePayrollDTO, payrollEntity );
        return payrollEntity;
    }
}

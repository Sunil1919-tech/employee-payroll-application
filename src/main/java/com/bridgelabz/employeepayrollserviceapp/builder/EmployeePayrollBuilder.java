package com.bridgelabz.employeepayrollserviceapp.builder;

import com.bridgelabz.employeepayrollserviceapp.dto.EmployeePayrollDTO;
import com.bridgelabz.employeepayrollserviceapp.entity.EmployeePayrollEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Purpose: Builder layer has the builder class that converts the employeePayroll DTO to payroll Entity
 *
 * @author Sunil
 * @version 0.0.1
 * @since 07/12/2021
 */
@Component
public class EmployeePayrollBuilder {
    @Autowired
    private ModelMapper modelMapper;

    /**
     * Purpose: to map dto to entity
     *
     * @param employeePayrollDTO: the entry values which maps to the EmployeeEntity
     * @param payrollEntity:      the entity mapped from the dto
     * @return payrollEntity mapped data
     */
    public EmployeePayrollEntity buildPayrollEntity(EmployeePayrollDTO employeePayrollDTO,
                                                    EmployeePayrollEntity payrollEntity) {
        modelMapper.map(employeePayrollDTO, payrollEntity);
        return payrollEntity;
    }
}

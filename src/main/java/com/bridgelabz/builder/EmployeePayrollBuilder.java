package com.bridgelabz.builder;

import com.bridgelabz.dto.EmployeePayrollDTO;
import com.bridgelabz.entity.EmployeePayrollEntity;
import org.modelmapper.ModelMapper;
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

    private final ModelMapper modelMapper= new ModelMapper();

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

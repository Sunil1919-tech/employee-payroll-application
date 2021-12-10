package com.bridgelabz.employeepayrollserviceapp.services;

import com.bridgelabz.employeepayrollserviceapp.dto.EmployeePayrollDTO;
import com.bridgelabz.employeepayrollserviceapp.entity.EmployeePayrollDataEntity;

import java.util.List;

public interface IEmployeePayrollService {
    List<EmployeePayrollDataEntity> getEmployeePayrolldata();

    EmployeePayrollDataEntity getEmployeeDataById(int employeeId);

    EmployeePayrollDataEntity createEmployeePayrollData(
            EmployeePayrollDTO employeePayrollDTO);

    EmployeePayrollDataEntity updateEmployeePayrollData(int empId,
                                                        EmployeePayrollDTO employeePayrollDTO);

    void deleteEmployeePayrollData(int empId);


}

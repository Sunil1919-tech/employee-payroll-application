package com.bridgelabz.employeepayrollserviceapp.services;

import com.bridgelabz.employeepayrollserviceapp.dto.EmployeePayrollDTO;
import com.bridgelabz.employeepayrollserviceapp.entity.EmployeePayrollDataEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeePayrollService implements IEmployeePayrollService {


    @Override
    public List<EmployeePayrollDataEntity> getEmployeePayrolldata() {
        List<EmployeePayrollDataEntity> entityList = new ArrayList<>();
        entityList.add(new EmployeePayrollDataEntity(1, new EmployeePayrollDTO("Sunil", 3000)));
        return entityList;
    }

    @Override
    public EmployeePayrollDataEntity getEmployeeDataById(int employeeId) {
        EmployeePayrollDataEntity employeePayrollData = null;
        employeePayrollData = new EmployeePayrollDataEntity(employeeId,
                new EmployeePayrollDTO("Subhash", 2000));

        return employeePayrollData;
    }

    @Override
    public EmployeePayrollDataEntity createEmployeePayrollData(EmployeePayrollDTO employeePayrollDTO) {
        EmployeePayrollDataEntity employeePayrollData = null;
        employeePayrollData = new EmployeePayrollDataEntity(1, employeePayrollDTO);
        return employeePayrollData;
    }

    @Override
    public EmployeePayrollDataEntity updateEmployeePayrollData(int empId, EmployeePayrollDTO employeePayrollDTO) {
        EmployeePayrollDataEntity employeePayrollData = null;
        employeePayrollData = new EmployeePayrollDataEntity(empId, employeePayrollDTO);
        return employeePayrollData;
    }

    @Override
    public void deleteEmployeePayrollData(int empId) {

    }
}

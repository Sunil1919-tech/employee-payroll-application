package com.bridgelabz.employeepayrollserviceapp.services;

import com.bridgelabz.employeepayrollserviceapp.dto.EmployeePayrollDTO;
import com.bridgelabz.employeepayrollserviceapp.entity.EmployeePayrollDataEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeePayrollService implements IEmployeePayrollService {

    private List<EmployeePayrollDataEntity> employeePayrollList = new ArrayList<>();

    @Override
    public List<EmployeePayrollDataEntity> getEmployeePayrolldata() {
        return employeePayrollList;
    }

    @Override
    public EmployeePayrollDataEntity getEmployeeDataById(int employeeId) {
        return employeePayrollList.get(employeeId - 1);
    }

    @Override
    public EmployeePayrollDataEntity createEmployeePayrollData(EmployeePayrollDTO employeePayrollDTO) {
        EmployeePayrollDataEntity employeePayrollData = null;
        employeePayrollData = new EmployeePayrollDataEntity(employeePayrollList.size() + 1, employeePayrollDTO);
        employeePayrollList.add(employeePayrollData);
        return employeePayrollData;
    }

    @Override
    public EmployeePayrollDataEntity updateEmployeePayrollData(int empId, EmployeePayrollDTO employeePayrollDTO) {
        EmployeePayrollDataEntity employeePayrollData = this.getEmployeeDataById(empId);
        employeePayrollData.setName(employeePayrollDTO.name);
        employeePayrollData.setSalary(employeePayrollDTO.salary);
        employeePayrollList.set(empId - 1, employeePayrollData);
        return employeePayrollData;
    }

    @Override
    public void deleteEmployeePayrollData(int empId) {

        employeePayrollList.remove(empId - 1);
    }
}

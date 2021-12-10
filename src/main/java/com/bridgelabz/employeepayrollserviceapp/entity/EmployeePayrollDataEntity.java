package com.bridgelabz.employeepayrollserviceapp.entity;

import com.bridgelabz.employeepayrollserviceapp.dto.EmployeePayrollDTO;

public class EmployeePayrollDataEntity {
    private int employeeId;
    private String name;
    private long salary;

//public EmployeePayrollData(){}

    public EmployeePayrollDataEntity(int employeeId, EmployeePayrollDTO employeePayrollDTO) {
        this.employeeId = employeeId;
        this.name = employeePayrollDTO.name;
        this.salary = employeePayrollDTO.salary;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getSalary() {
        return salary;
    }

    public void setSalary(long salary) {
        this.salary = salary;
    }
}

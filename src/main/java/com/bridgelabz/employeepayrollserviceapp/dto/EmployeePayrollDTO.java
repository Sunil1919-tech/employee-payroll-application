package com.bridgelabz.employeepayrollserviceapp.dto;

public class EmployeePayrollDTO {
    private final String name;
    private final long salary;

    public EmployeePayrollDTO(String name, long salary){
        this.name=name;
        this.salary=salary;
    }

    @Override
    public String toString() {
        return "EmployeePayrollDTO{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }
}


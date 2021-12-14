package com.bridgelabz.employeepayrollserviceapp.dto;

import lombok.Data;

import javax.validation.constraints.Pattern;

@Data
public class EmployeePayrollDTO {


    @Pattern( regexp = "^[A-Z]{1}[a-z]{3,15}",message = "Name Invalid")
    private String name;


    @Pattern( regexp = "^M(ale)?$|^F(emale)?$|^O(ther)?$",message = "Gender Invalid")
    private String gender;


    @Pattern( regexp = "[0-9]{3,}$",message = "Salary Invalid")
    public String salary;


    @Pattern(regexp = "^[A-Za-z]{2,}$",message="Department Invalid")
    private String department;


    private String notes;
}


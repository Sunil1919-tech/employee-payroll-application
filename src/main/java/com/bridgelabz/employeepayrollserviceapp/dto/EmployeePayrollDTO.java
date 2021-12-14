package com.bridgelabz.employeepayrollserviceapp.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Data
public class EmployeePayrollDTO {

    @NotNull
    @Pattern( regexp = "^[A-Z]{1}[a-z]{3,15}",message = "Name Invalid")
    private String name;

    @NotNull
    @Pattern( regexp = "^M(ale)?$|^F(emale)?$|^O(ther)?$",message = "Gender Invalid")
    private String gender;

    @NotNull
    @Pattern( regexp = "[0-9]{3,}$",message = "Salary Invalid")
    public long salary;

    @NotNull
    @Pattern(regexp = "^[A-Za-z]{3,}$",message="Department Invalid")
    private String department;

    @NotNull
    private String notes;
}


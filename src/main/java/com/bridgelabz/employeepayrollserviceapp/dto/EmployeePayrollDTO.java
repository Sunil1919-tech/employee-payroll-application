package com.bridgelabz.employeepayrollserviceapp.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 * Purpose: to get the input from the client end to the server
 *  declared regex pattern for validation
 *
 * @author Sunil
 * @version 0.0.1
 * @since 07/12/2021
 */
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
    public String salary;

    @NotNull
    @Pattern(regexp = "^[A-Za-z]{2,}$",message="Department Invalid")
    private String department;

    private String notes;
}


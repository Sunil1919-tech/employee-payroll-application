package com.bridgelabz.controller;

import com.bridgelabz.dto.EmployeePayrollDTO;
import com.bridgelabz.services.EmployeePayrollService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class EmployeePayrollControllerTest {

    @InjectMocks
    private EmployeePayrollController payrollController;
    @Mock
    private EmployeePayrollService employeePayrollService;

    @Test
    void whenGetAllEmployeeDetailsCalled_shouldReturnGetEmployeeList() {
        List<EmployeePayrollDTO> employeePayrollDTOList = new ArrayList<>();
        EmployeePayrollDTO employeePayrollDTO1 = new EmployeePayrollDTO();
        employeePayrollDTO1.setName("Sunil");
        employeePayrollDTO1.setGender("Male");
        employeePayrollDTO1.setSalary("3000");
        employeePayrollDTO1.setDepartment("It");
        employeePayrollDTO1.setNotes("Good person, Workaholic");
        employeePayrollDTOList.add(employeePayrollDTO1);
        EmployeePayrollDTO employeePayrollDTO2 = new EmployeePayrollDTO();
        employeePayrollDTO2.setName("Ria");
        employeePayrollDTO2.setGender("Female");
        employeePayrollDTO2.setSalary("2000");
        employeePayrollDTO2.setDepartment("Helpdesk");
        employeePayrollDTO2.setNotes("very nice");
        employeePayrollDTOList.add(employeePayrollDTO2);
        when(employeePayrollService.getEmployeePayrollList()).thenReturn(employeePayrollDTOList);
        List<EmployeePayrollDTO> actualResponse = payrollController.getAllEmployeeDetails();
        for (int i = 0; i < actualResponse.size(); i++) {
            assertEquals(employeePayrollDTOList.get(i).getName(), actualResponse.get(i).getName());
            assertEquals(employeePayrollDTOList.get(i).getGender(), actualResponse.get(i).getGender());
            assertEquals(employeePayrollDTOList.get(i).getSalary(), actualResponse.get(i).getSalary());
            assertEquals(employeePayrollDTOList.get(i).getDepartment(), actualResponse.get(i).getDepartment());
            assertEquals(employeePayrollDTOList.get(i).getNotes(), actualResponse.get(i).getNotes());
        }
    }
}

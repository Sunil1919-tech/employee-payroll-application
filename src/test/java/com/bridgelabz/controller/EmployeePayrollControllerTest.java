package com.bridgelabz.controller;

import com.bridgelabz.dto.EmployeePayrollDTO;
import com.bridgelabz.services.EmployeePayrollService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

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
        employeePayrollDTO1.setSalary("33000");
        employeePayrollDTO1.setDepartments("It");
        employeePayrollDTO1.setNote("Good person, Workaholic");
        employeePayrollDTOList.add(employeePayrollDTO1);
        EmployeePayrollDTO employeePayrollDTO2 = new EmployeePayrollDTO();
        employeePayrollDTO2.setName("Ria");
        employeePayrollDTO2.setGender("Female");
        employeePayrollDTO2.setSalary("25000");
        employeePayrollDTO2.setDepartments("Helpdesk");
        employeePayrollDTO2.setNote("very nice");
        employeePayrollDTOList.add(employeePayrollDTO2);
        when(employeePayrollService.getEmployeePayrollList()).thenReturn(employeePayrollDTOList);
        List<EmployeePayrollDTO> actualResponse = payrollController.getAllEmployeeDetails();
        for (int i = 0; i < actualResponse.size(); i++) {
            assertEquals(employeePayrollDTOList.get(i).getName(), actualResponse.get(i).getName());
            assertEquals(employeePayrollDTOList.get(i).getGender(), actualResponse.get(i).getGender());
            assertEquals(employeePayrollDTOList.get(i).getSalary(), actualResponse.get(i).getSalary());
            assertEquals(employeePayrollDTOList.get(i).getDepartments(), actualResponse.get(i).getDepartments());
            assertEquals(employeePayrollDTOList.get(i).getNote(), actualResponse.get(i).getNote());
        }
    }

    @Test
    void whenAddEmployeeCalled_shouldAddEmployeeDetailsAnd_generateSucceedMessage() {
        String successMessage = " Added Employee Details Successfully";
        ResponseEntity<String> expectedResponseEntity = new ResponseEntity<>(successMessage, HttpStatus.OK);
        EmployeePayrollDTO employeePayrollDTO = new EmployeePayrollDTO();
        employeePayrollDTO.setName("Sunil");
        employeePayrollDTO.setGender("Male");
        employeePayrollDTO.setSalary("33000");
        employeePayrollDTO.setDepartments("It");
        employeePayrollDTO.setNote("Good person, Workaholic");
        when(employeePayrollService.addEmployeeData(employeePayrollDTO)).thenReturn(successMessage);
        ResponseEntity<String> message = payrollController.addEmployeePayrollData(employeePayrollDTO);
        assertEquals(expectedResponseEntity, message);
    }

    @Test
    void whenUpdateEmployeeDetailCalledByID_shouldUpdateEmployeeAndGenerateSucceedMessage() {
        String successMessage = "Employee Details Updated Successfully";
        int empID = 1;
        ResponseEntity<String> expectedResponseEntity = new ResponseEntity<>(successMessage, HttpStatus.OK);
        EmployeePayrollDTO employeePayrollDTO = new EmployeePayrollDTO();
        employeePayrollDTO.setName("Sunil");
        employeePayrollDTO.setGender("Male");
        employeePayrollDTO.setSalary("33000");
        employeePayrollDTO.setDepartments("It");
        employeePayrollDTO.setNote("Good person, Workaholic");
        when(employeePayrollService.updateEmployeeDetails(empID, employeePayrollDTO)).thenReturn(successMessage);
        ResponseEntity<String> actualResponse = payrollController.updateEmployee(empID, employeePayrollDTO);
        assertEquals(expectedResponseEntity, actualResponse);
    }

    @Test
    void whenDeleteEmployeeCalled_withGivenID_shouldDeleteEmployeeAndReturnSucceedMessage() {
        String successMessage = "Deleted employee Details Successfully";
        int empID = 1;
        ResponseEntity<String> expectedResponseEntity = new ResponseEntity<>(successMessage, HttpStatus.OK);
        when(employeePayrollService.deleteEmployee(empID)).thenReturn(successMessage);
        ResponseEntity<String> actualResponse = payrollController.deleteEmployee(empID);
        assertEquals(expectedResponseEntity, actualResponse);
    }
}

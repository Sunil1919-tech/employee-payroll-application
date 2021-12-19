package com.bridgelabz.integration;

import com.bridgelabz.controller.EmployeePayrollController;
import com.bridgelabz.dto.EmployeePayrollDTO;
import com.bridgelabz.services.EmployeePayrollService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@ActiveProfiles("test")
@WebMvcTest(EmployeePayrollController.class)
public class PayrollControllerIntegrationTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private EmployeePayrollService employeePayrollService;

    @Test
    void getEmployeeListTest() throws Exception {
        when(employeePayrollService.getEmployeePayrollList()).thenReturn(new ArrayList<>());
        mockMvc.perform(MockMvcRequestBuilders.get("/employee-payroll-service/employee")).andExpect(status().isOk());
    }

    @Test
    void addEmployeeDetailsTest() throws Exception {
        when(employeePayrollService.addEmployeeData(any())).thenReturn("Success");
        mockMvc.perform(MockMvcRequestBuilders
                        .post("/employee-payroll-service/employee")
                        .content("{\"name\":\"Sunil\",\"gender\":\"Male\",\"salary\":\"22000\",\"department\":\"it\"," +
                                "\"note\":\"good person\",\"startDate\":\"19/12/2021\"}")
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk());

    }

    @Test
    void updateEmployeeDetailTest() throws Exception {

        EmployeePayrollDTO payrollDTO = new EmployeePayrollDTO();
        payrollDTO.setName("Sunil");
        payrollDTO.setGender("Male");
        payrollDTO.setSalary("32000");
        payrollDTO.setDepartment("devops");
        payrollDTO.setNotes("very true");
        int empId = 1;
        when(employeePayrollService.updateEmployeeDetails(empId, payrollDTO)).thenReturn("Success");
        mockMvc.perform(MockMvcRequestBuilders
                        .put("/employee-payroll-service/employee/1")
                        .content("{\"name\":\"Justin\",\"gender\":\"Male\",\"salary\":\"34000\",\"department\":\"Hr\"," +
                                "\"note\":\"good logical thinking\",\"startDate\":\"19/12/2021\"}")
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk());
    }

    @Test
    void deleteEmployeeDetailsTest() throws Exception {
        when(employeePayrollService.deleteEmployee(1)).thenReturn("Success");
        mockMvc.perform(MockMvcRequestBuilders
                        .delete("/employee-payroll-service/employee/1")
                        .content("{\"name\":\"Justin\",\"gender\":\"Male\",\"salary\":\"34000\",\"department\":\"Hr\"," +
                                "\"note\":\"good logical thinking\",\"startDate\":\"19/12/2021\"}")
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk());

    }
}

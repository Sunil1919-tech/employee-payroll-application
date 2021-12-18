package com.bridgelabz.service;

import com.bridgelabz.builder.EmployeePayrollBuilder;
import com.bridgelabz.dto.EmployeePayrollDTO;
import com.bridgelabz.entity.EmployeePayrollEntity;
import com.bridgelabz.exceptions.DataNotFoundException;
import com.bridgelabz.repository.EmployeePayrollRepository;
import com.bridgelabz.services.EmployeePayrollService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class EmployeePayrollServiceTest {

    @InjectMocks
    private EmployeePayrollService payrollService;

    @Mock
    private EmployeePayrollRepository payrollRepository;

    @Mock
    private ModelMapper modelMapper;

    @Mock
    private EmployeePayrollBuilder payrollBuilder;

    @Test
    void whenGetAllEmployeeCalled_shouldReturnEmployeeList() {
        List<EmployeePayrollEntity> payrollEntityList = new ArrayList<>();
        EmployeePayrollEntity payrollEntity1 = new EmployeePayrollEntity();
        payrollEntity1.setEmployeeId(1);
        payrollEntity1.setName("Sunil");
        payrollEntity1.setGender("Male");
        payrollEntity1.setSalary("33000");
        payrollEntity1.setDepartment("It");
        payrollEntity1.setNote("Good person, Workaholic");
        payrollEntity1.setStartDate(LocalDateTime.now());
        payrollEntityList.add(payrollEntity1);
        EmployeePayrollEntity payrollEntity2 = new EmployeePayrollEntity();
        payrollEntity2.setEmployeeId(2);
        payrollEntity2.setName("Ria");
        payrollEntity2.setGender("Female");
        payrollEntity2.setSalary("25000");
        payrollEntity2.setDepartment("Helpdesk");
        payrollEntity2.setNote("very nice");
        payrollEntity2.setStartDate(LocalDateTime.now());
        payrollEntityList.add(payrollEntity2);
        List<EmployeePayrollDTO> employeePayrollDTOList = new ArrayList<>();
        EmployeePayrollDTO employeePayrollDTO1 = new EmployeePayrollDTO();
        employeePayrollDTO1.setName("Sunil");
        employeePayrollDTO1.setGender("Male");
        employeePayrollDTO1.setSalary("33000");
        employeePayrollDTO1.setDepartment("It");
        employeePayrollDTO1.setNotes("Good person, Workaholic");
        employeePayrollDTOList.add(employeePayrollDTO1);
        EmployeePayrollDTO employeePayrollDTO2 = new EmployeePayrollDTO();
        employeePayrollDTO2.setName("Ria");
        employeePayrollDTO2.setGender("Female");
        employeePayrollDTO2.setSalary("25000");
        employeePayrollDTO2.setDepartment("Helpdesk");
        employeePayrollDTO2.setNotes("very nice");
        employeePayrollDTOList.add(employeePayrollDTO2);
        when(payrollRepository.findAll()).thenReturn(payrollEntityList);
        when(modelMapper.map(payrollEntityList.get(0), EmployeePayrollDTO.class)).thenReturn(employeePayrollDTO1);
        when(modelMapper.map(payrollEntityList.get(1), EmployeePayrollDTO.class)).thenReturn(employeePayrollDTO2);
        List<EmployeePayrollDTO> actualEmployeeList = payrollService.getEmployeePayrollList();
        assertEquals(2, actualEmployeeList.size());
        assertEquals(employeePayrollDTOList, actualEmployeeList);
    }

    @Test
    void whenAddEmployeeCalled_shouldAddEmployeeDetailsAndGenerateSucceedMessage() {
        EmployeePayrollDTO employeePayrollDTO = new EmployeePayrollDTO();
        String successMessage = "Added Employee Details Successfully";
        employeePayrollDTO.setName("Sunil");
        employeePayrollDTO.setGender("Male");
        employeePayrollDTO.setSalary("33000");
        employeePayrollDTO.setDepartment("It");
        employeePayrollDTO.setNotes("Good person, Workaholic");

        EmployeePayrollEntity payrollEntity = new EmployeePayrollEntity();
        payrollEntity.setEmployeeId(1);
        payrollEntity.setName("Sunil");
        payrollEntity.setGender("Male");
        payrollEntity.setSalary("33000");
        payrollEntity.setDepartment("It");
        payrollEntity.setNote("Good person, Workaholic");
        payrollEntity.setStartDate(LocalDateTime.now());
        when(modelMapper.map(employeePayrollDTO, EmployeePayrollEntity.class)).thenReturn(payrollEntity);
        String actualResponse = payrollService.addEmployeeData(employeePayrollDTO);
        assertEquals(successMessage, actualResponse);
        verify(payrollRepository, times(1)).save(payrollEntity);
    }

    @Test
    void whenUpdateEmployeeCalled_thenFindById_shouldThrowExceptionMessage() {
        int id = 1;
        EmployeePayrollDTO employeePayrollDTO = new EmployeePayrollDTO();
        employeePayrollDTO.setName("Sunil");
        employeePayrollDTO.setGender("Male");
        employeePayrollDTO.setSalary("33000");
        employeePayrollDTO.setDepartment("It");
        employeePayrollDTO.setNotes("Good person, Workaholic");
        when(payrollRepository.findById(id)).thenReturn(Optional.empty());
        assertThrows(DataNotFoundException.class,
                () -> payrollService.updateEmployeeDetails(id, employeePayrollDTO));
    }

    @Test
    void whenUpdateEmployeeCalledByEmpId_shouldGenerateSucceedMessage() {
        int empId = 1;
        ArgumentCaptor<EmployeePayrollEntity> payrollEntityArgumentCaptor = ArgumentCaptor
                .forClass(EmployeePayrollEntity.class);
        String successMessage = "Employee Details Updated Successfully";
        EmployeePayrollDTO employeePayrollDTO = new EmployeePayrollDTO();
        employeePayrollDTO.setName("Sunil");
        employeePayrollDTO.setGender("Male");
        employeePayrollDTO.setSalary("33000");
        employeePayrollDTO.setDepartment("It");
        employeePayrollDTO.setNotes("Good person, Workaholic");

        EmployeePayrollEntity payrollEntity = new EmployeePayrollEntity();
        payrollEntity.setEmployeeId(1);
        payrollEntity.setName("Sunil");
        payrollEntity.setGender("Male");
        payrollEntity.setSalary("33000");
        payrollEntity.setDepartment("It");
        payrollEntity.setNote("Good person, Workaholic");
        payrollEntity.setStartDate(LocalDateTime.now());
        when(payrollRepository.findById(empId)).thenReturn(Optional.of(payrollEntity));
        when(payrollBuilder.buildPayrollEntity(employeePayrollDTO, payrollEntity)).thenReturn(payrollEntity);
        String actualResponseMessage = payrollService.updateEmployeeDetails(empId, employeePayrollDTO);
        verify(payrollRepository, times(1)).save(payrollEntityArgumentCaptor.capture());
        assertEquals(payrollEntity.getName(), payrollEntityArgumentCaptor.getValue().getName());
        assertEquals(payrollEntity.getGender(), payrollEntityArgumentCaptor.getValue().getGender());
        assertEquals(payrollEntity.getSalary(), payrollEntityArgumentCaptor.getValue().getSalary());
        assertEquals(payrollEntity.getDepartment(), payrollEntityArgumentCaptor.getValue().getDepartment());
        assertEquals(payrollEntity.getNote(), payrollEntityArgumentCaptor.getValue().getNote());
        assertEquals(payrollEntity.getStartDate(), payrollEntityArgumentCaptor.getValue().getStartDate());
    }

    @Test
    void whenEmployeeDetailsFindByIdCalled_thenIdNotFound_shouldThrowException() {
        int empId = 1;
        when(payrollRepository.findById(empId)).thenReturn(Optional.empty());
        assertThrows(DataNotFoundException.class, () -> payrollService.getEmployeeByID(empId));
    }

    @Test
    void whenDeleteEmployeeCalled_shouldDeleteDetailsAndRetrunSucceedMessage() {
        String successMessage = "Deleted employee Details Successfully";
        int empId = 1;
        EmployeePayrollDTO employeePayrollDTO = new EmployeePayrollDTO();
        employeePayrollDTO.setName("Sunil");
        employeePayrollDTO.setGender("Male");
        employeePayrollDTO.setSalary("33000");
        employeePayrollDTO.setDepartment("It");
        employeePayrollDTO.setNotes("Good person, Workaholic");

        EmployeePayrollEntity payrollEntity = new EmployeePayrollEntity();
        payrollEntity.setEmployeeId(1);
        payrollEntity.setName("Sunil");
        payrollEntity.setGender("Male");
        payrollEntity.setSalary("33000");
        payrollEntity.setDepartment("It");
        payrollEntity.setNote("Good person, Workaholic");
        payrollEntity.setStartDate(LocalDateTime.now());
        when(payrollRepository.findById(empId)).thenReturn(Optional.of(payrollEntity));
        String actualResponseMessage = payrollService.deleteEmployee(empId);
        assertEquals(successMessage, actualResponseMessage);
        verify(payrollRepository, times(1)).delete(payrollEntity);
    }
}

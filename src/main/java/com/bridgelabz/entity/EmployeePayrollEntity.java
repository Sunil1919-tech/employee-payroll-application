package com.bridgelabz.entity;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * Purpose: initializing the inputs to connect with the server
 *
 * @author Sunil
 * @version 0.0.1
 * @since 07/12/2021
 */
@Data
@Entity
@Table(name = "employee_service")
public class EmployeePayrollEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int employeeId;
    private String name;
    private String gender;
    private String salary;
    private String department;
    private String note;
    @CreationTimestamp
    private LocalDateTime startDate;
}




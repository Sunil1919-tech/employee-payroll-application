package com.bridgelabz.employeepayrollserviceapp.entity;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import javax.persistence.*;
import java.time.LocalDateTime;


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




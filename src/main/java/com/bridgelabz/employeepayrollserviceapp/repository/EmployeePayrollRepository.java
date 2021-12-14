package com.bridgelabz.employeepayrollserviceapp.repository;

import com.bridgelabz.employeepayrollserviceapp.entity.EmployeePayrollEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeePayrollRepository extends JpaRepository<EmployeePayrollEntity, Integer> {

}

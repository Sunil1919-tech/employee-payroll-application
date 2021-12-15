package com.bridgelabz.employeepayrollserviceapp.repository;

import com.bridgelabz.employeepayrollserviceapp.entity.EmployeePayrollEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Purpose: for managing database operations
 *
 * @author Sunil
 * @version 0.0.1
 * @since 07/12/2021
 */
public interface EmployeePayrollRepository extends JpaRepository<EmployeePayrollEntity, Integer> {

}

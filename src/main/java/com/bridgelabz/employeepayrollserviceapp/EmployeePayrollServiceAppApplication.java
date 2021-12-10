package com.bridgelabz.employeepayrollserviceapp;

import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableEncryptableProperties
public class EmployeePayrollServiceAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(EmployeePayrollServiceAppApplication.class, args);
    }

}

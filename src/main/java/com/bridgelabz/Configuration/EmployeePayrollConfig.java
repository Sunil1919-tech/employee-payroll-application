package com.bridgelabz.Configuration;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Purpose: for model mapper configuration
 *
 * @author Sunil
 * @version 0.0.1
 * @since 07/12/2021
 */
@Configuration
public class EmployeePayrollConfig {

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}

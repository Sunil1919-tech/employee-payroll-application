package com.bridgelabz.employeepayrollserviceapp.Configuration;

        import org.modelmapper.ModelMapper;
        import org.springframework.context.annotation.Bean;
        import org.springframework.context.annotation.Configuration;

@Configuration
public class EmployeePayrollConfig {

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}

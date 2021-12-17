package com.bridgelabz.Configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfiguration {
    @Bean
    public Docket postApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("Address Book")
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.bridgelabz.controller"))
                .build();
    }
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("Address Book Application")
                .description("Sample Documentation Generated Using SWAGGER2 for Address Book Application")
                .termsOfServiceUrl("https://github.com/Sunil1919-tech")
                .license("License")
                .licenseUrl("https://github.com/Sunil1919-tech")
                .version("1.0")
                .build();
    }
}

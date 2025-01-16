package com.example.sscc_validator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.example.sscc_validator.repository")
@EntityScan(basePackages = "com.example.sscc_validator.model")
public class SsccValidatorApplication {

    public static void main(String[] args) {
        SpringApplication.run(SsccValidatorApplication.class, args);
    }
}
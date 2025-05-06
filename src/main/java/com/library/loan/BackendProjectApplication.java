package com.library.loan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.library.loan.repository") // Ensure this points to the correct package
@EntityScan(basePackages = "com.library.loan.model") // Ensure this points to the correct package for entities

public class BackendProjectApplication {
    public static void main(String[] args) {
        SpringApplication.run(BackendProjectApplication.class, args);
    }
}

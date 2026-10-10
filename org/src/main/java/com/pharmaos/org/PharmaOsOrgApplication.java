package com.pharmaos.org;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(
        scanBasePackages = "com.pharmaos"
)
public class PharmaOsOrgApplication {

    public static void main(String[] args) {
        SpringApplication.run(PharmaOsOrgApplication.class, args);
    }
}
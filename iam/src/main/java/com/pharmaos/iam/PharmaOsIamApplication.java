package com.pharmaos.iam;

import com.pharmaos.iam.controller.AuthController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.pharmaos")
public class PharmaOsIamApplication {

    public static void main(String[] args) {
        SpringApplication.run(PharmaOsIamApplication.class, args);

        System.out.println(AuthController.class.getName());
    }
}
package com.food;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FoodApp {
    public static void main(String[] args) {
        // This launches the Spring Boot application on localhost:8080 by default
        SpringApplication.run(FoodApp.class, args);
    }
}

package com.cognologix.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * The type Spring boot app.
 */
@SpringBootConfiguration
@SpringBootApplication
public class SpringBootApp {
    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        SpringApplication.run(SpringBootApp.class, args);
    }
}

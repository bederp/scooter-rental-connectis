package com.example.scooterRentalApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource("classpath:message.properties")
@ComponentScan(basePackages = {
		"com.example.scooterRentalApp.controller",
		"com.example.scooterRentalApp.repository",
		"com.example.scooterRentalApp.common",
		"com.example.scooterRentalApp.service"
})
public class ScooterRentalAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(ScooterRentalAppApplication.class, args);
	}

}

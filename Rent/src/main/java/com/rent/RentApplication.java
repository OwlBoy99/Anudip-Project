package com.rent;


import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;

import com.rent.service.DatabaseCheckService;
@SpringBootApplication

@EntityScan(basePackages = "com.rent.model")
public class RentApplication {

	public static void main(String[] args) {
		SpringApplication.run(RentApplication.class, args);
		System.out.println("Server Started");
	}
	 @Bean
	    public CommandLineRunner checkDatabaseConnection(DatabaseCheckService databaseCheckService) {
	        return args -> {
	            // Invoke the database check during application startup
	            databaseCheckService.checkDatabaseConnection();
	        };
	    }
}

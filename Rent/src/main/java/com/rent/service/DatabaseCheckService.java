package com.rent.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.rent.model.Tenant;
import com.rent.repository.TenantRepository;


@Service
public class DatabaseCheckService {

    @Autowired
    private TenantRepository tenantRepository;

    public void checkDatabaseConnection() {
        try {
            // Try fetching something from the database
            List<Tenant> entities = tenantRepository.findAll();

            // If successful, print a message
            System.out.println("Database connection successful. Found " + entities.size() + " entities.");
        } catch (DataAccessException e) {
            // Catch more specific exception for database-related issues
            System.err.println("Error accessing the database: " + e.getMessage());
        } catch (Exception e) {
            // Catch any other unexpected exceptions
            System.err.println("Unexpected error: " + e.getMessage());
        }
    }
}


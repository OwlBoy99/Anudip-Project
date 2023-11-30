package com.rent.service;

import com.rent.model.Property;

import java.util.List;

import org.springframework.http.ResponseEntity;

public interface PropertyService {

    List<Property> getAllProperties();

    Property getPropertyById(Long id);
    
    Property getPropertyByName(String propertyName);
    
    ResponseEntity<Void> saveProperty(Property property);
    
    Property updateProperty(Long id, Property updatedProperty);

    ResponseEntity<Void> deleteProperty(Long id);
    
}


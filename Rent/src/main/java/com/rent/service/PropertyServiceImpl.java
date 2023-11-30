package com.rent.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.rent.model.Property;
import com.rent.repository.PropertyRepository;

@Service
public class PropertyServiceImpl implements PropertyService {

    private final PropertyRepository propertyRepository;

    @Autowired
    public PropertyServiceImpl(PropertyRepository propertyRepository) {
        this.propertyRepository = propertyRepository;
    }

    @Override
    public List<Property> getAllProperties() {
        return propertyRepository.findAll();
    }

    @Override
    public Property getPropertyById(Long id) {
        return propertyRepository.findById(id).orElse(null);
    }
    @Override
    public ResponseEntity<Void> saveProperty(Property property) {
        Property savedProperty = propertyRepository.save(property);
        // Assuming you want to return a success status code
        return new ResponseEntity<>(HttpStatus.OK);
    }


    @Override
    public Property updateProperty(Long id, Property updatedProperty) {
        Property property = propertyRepository.findById(id).orElse(null);
        if (property != null) {
            // Update other properties of the property
            property.setPropertyName(updatedProperty.getPropertyName());
            property.setPropertyType(updatedProperty.getPropertyType());
            // Update other fields as needed

            // Save the updated property
            return propertyRepository.save(property);
        } else {
            return null; // or throw an exception
        }
    }
    @Override
    public Property getPropertyByName(String propertyName) {
        return propertyRepository.findByPropertyName(propertyName);
    }
    @Override
    public ResponseEntity<Void> deleteProperty(Long id) {
        if (propertyRepository.existsById(id)) {
            propertyRepository.deleteById(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

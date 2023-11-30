package com.rent.controller;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.rent.model.Property;
import com.rent.service.PropertyService;
@RestController
@RequestMapping("/api/properties")
@CrossOrigin(origins = "*")
public class PropertyController {

    @Autowired
    private PropertyService propertyService;

    private static final String UPLOAD_DIR = "C:\\Users\\Lenovo\\images";

    @GetMapping
    public List<Property> getAllProperties() {
        return propertyService.getAllProperties();
    }

    @GetMapping("/{id}")
    public Property getPropertyById(@PathVariable Long id) {
        return propertyService.getPropertyById(id);
    }

    @PostMapping
    public ResponseEntity<Void> saveProperty(
            @RequestParam("imageUrl") MultipartFile imageUrl,
            @RequestParam("propertyName") String propertyName,
            @RequestParam("propertyType") String propertyType,
            @RequestParam("price") double price,
            @RequestParam("contactNumber") String contactNumber) {

        try {
            // Check if the file is not empty
            if (!imageUrl.isEmpty()) {
                // Create the directory if it doesn't exist
                Path uploadPath = Paths.get(UPLOAD_DIR);
                if (!uploadPath.toFile().exists()) {
                    uploadPath.toFile().mkdirs();
                }

                Path filePath = uploadPath.resolve(imageUrl.getOriginalFilename());
                imageUrl.transferTo(filePath.toFile());

                // Create a Property object with the file path and other details
                Property property = new Property();
                property.setImageUrl(filePath.toString());
                property.setPropertyName(propertyName);
                property.setPropertyType(propertyType);
                property.setPrice(price);
                property.setContactNumber(contactNumber); // Set the contact number

                // Save the property to the database
                propertyService.saveProperty(property);

                return new ResponseEntity<>(HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
        } catch (Exception e) {
            // Handle the exception (e.g., log it)
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{propertyName}")
    public ResponseEntity<Void> updateProperty(@PathVariable String propertyName, @RequestBody Property updatedProperty) {
        try {
            Property existingProperty = propertyService.getPropertyByName(propertyName);
            if (existingProperty != null) {
                // Update only the fields that are not null in the request
                if (updatedProperty.getPropertyName() != null) {
                    existingProperty.setPropertyName(updatedProperty.getPropertyName());
                }
                if (updatedProperty.getPropertyType() != null) {
                    existingProperty.setPropertyType(updatedProperty.getPropertyType());
                }
                if (updatedProperty.getPrice() != null) {
                    existingProperty.setPrice(updatedProperty.getPrice());
                }
                if (updatedProperty.getContactNumber() != null) {
                    existingProperty.setContactNumber(updatedProperty.getContactNumber());
                }

                // Save the updated property to the database
                propertyService.saveProperty(existingProperty);

                return new ResponseEntity<>(HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            // Handle the exception (e.g., log it)
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProperty(@PathVariable Long id) {
        try {
            Property propertyToDelete = propertyService.getPropertyById(id);
            if (propertyToDelete != null) {
                // Delete the property from the database
                propertyService.deleteProperty(id);

                return new ResponseEntity<>(HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            // Handle the exception (e.g., log it)
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
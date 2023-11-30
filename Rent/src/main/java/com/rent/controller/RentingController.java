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

import com.rent.model.RentHouse;
import com.rent.service.RentingService;

@RestController
@RequestMapping("/api/rent-houses")
@CrossOrigin(origins = "*")
public class RentingController {

    @Autowired
    private RentingService rentingService;

    private static final String UPLOAD_DIR = "C:\\Users\\Lenovo\\images"; // Adjust the path as needed

    @GetMapping
    public List<RentHouse> getAllRentHouses() {
        return rentingService.getAllRentHouses();
    }

    @GetMapping("/{id}")
    public RentHouse getRentHouseById(@PathVariable Long id) {
        return rentingService.getRentHouseById(id);
    }

    @PostMapping
    public ResponseEntity<Void> saveRentHouse(
            @RequestParam("imageUrl") MultipartFile imageUrl,
            @RequestParam("propertyType") String propertyType,
            @RequestParam("rentPrice") Double rentPrice,
            @RequestParam("numberOfTenants") Integer numberOfTenants,
            @RequestParam("contactNumber") String contactNumber){

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

                // Create a RentHouse object with the file path and other details
                RentHouse rentHouse = new RentHouse();
                rentHouse.setImageUrl(filePath.toString());
                rentHouse.setPropertyType(propertyType);
                rentHouse.setRentPrice(rentPrice);
                rentHouse.setNumberOfTenants(numberOfTenants);
                rentHouse.setContactNumber(contactNumber);
                // Save the rent house to the database
                rentingService.saveRentHouse(rentHouse);

                return new ResponseEntity<>(HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
        } catch (Exception e) {
            // Handle the exception (e.g., log it)
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public RentHouse updateRentHouse(@PathVariable Long id, @RequestBody RentHouse updatedRentHouse) {
        return rentingService.updateRentHouse(id, updatedRentHouse);
    }

    @DeleteMapping("/{id}")
    public void deleteRentHouse(@PathVariable Long id) {
        rentingService.deleteRentHouse(id);
    }
}

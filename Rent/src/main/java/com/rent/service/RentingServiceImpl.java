package com.rent.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.rent.model.RentHouse;
import com.rent.repository.RentHouseRepository;

@Service
public class RentingServiceImpl implements RentingService {

    private final RentHouseRepository rentHouseRepository;

    @Autowired
    public RentingServiceImpl(RentHouseRepository rentHouseRepository) {
        this.rentHouseRepository = rentHouseRepository;
    }

    @Override
    public List<RentHouse> getAllRentHouses() {
        return rentHouseRepository.findAll();
    }

    @Override
    public RentHouse getRentHouseById(Long id) {
        return rentHouseRepository.findById(id).orElse(null);
    }

    @Override
    public ResponseEntity<Void> saveRentHouse(RentHouse rentHouse) {
        RentHouse savedRentHouse = rentHouseRepository.save(rentHouse);
        // Assuming you want to return a success status code
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Override
    public RentHouse updateRentHouse(Long id, RentHouse updatedRentHouse) {
        RentHouse rentHouse = rentHouseRepository.findById(id).orElse(null);
        if (rentHouse != null) {
            // Update other properties of the rent house
            rentHouse.setPropertyType(updatedRentHouse.getPropertyType());
            rentHouse.setRentPrice(updatedRentHouse.getRentPrice());
            rentHouse.setNumberOfTenants(updatedRentHouse.getNumberOfTenants());
            // Update other fields as needed

            // Save the updated rent house
            return rentHouseRepository.save(rentHouse);
        } else {
            return null; // or throw an exception
        }
    }

    @Override
    public void deleteRentHouse(Long id) {
        rentHouseRepository.deleteById(id);
    }
}

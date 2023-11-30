package com.rent.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.rent.model.RentHouse;

public interface RentingService {

    List<RentHouse> getAllRentHouses();

    RentHouse getRentHouseById(Long id);

    ResponseEntity<Void> saveRentHouse(RentHouse rentHouse);

    RentHouse updateRentHouse(Long id, RentHouse updatedRentHouse);

    void deleteRentHouse(Long id);
}

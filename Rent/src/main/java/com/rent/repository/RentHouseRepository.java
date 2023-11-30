package com.rent.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.rent.model.RentHouse;

public interface RentHouseRepository extends JpaRepository<RentHouse, Long> {
    // You can add custom queries if needed
}

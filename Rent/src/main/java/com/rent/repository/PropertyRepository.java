package com.rent.repository;

import com.rent.model.Property;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PropertyRepository extends JpaRepository<Property, Long> {
    // You can add custom queries if needed
	Property findByPropertyName(String propertyName);
}


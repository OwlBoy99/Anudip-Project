package com.rent.repository;

import com.rent.model.Tenant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TenantRepository extends JpaRepository<Tenant, Long> {
    // Custom queries can be added here if needed
}


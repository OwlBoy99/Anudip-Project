package com.rent.service;

import com.rent.model.Tenant;

import java.util.List;

public interface TenantService {

    List<Tenant> getAllTenants();

    Tenant getTenantById(Long id);

    Tenant saveTenant(Tenant tenant);

    void deleteTenant(Long id);
    Tenant updateTenant(Long id, Tenant updatedTenant);
}

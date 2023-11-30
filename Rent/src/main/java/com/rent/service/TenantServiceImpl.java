package com.rent.service;

import com.rent.model.Tenant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.rent.repository.TenantRepository; // Assuming you have a repository

import java.util.List;

@Service
public class TenantServiceImpl implements TenantService {

    private final TenantRepository tenantRepository;

    @Autowired
    public TenantServiceImpl(TenantRepository tenantRepository) {
        this.tenantRepository = tenantRepository;
    }

    @Override
    public List<Tenant> getAllTenants() {
        return tenantRepository.findAll();
    }

    @Override
    public Tenant getTenantById(Long id) {
        return tenantRepository.findById(id).orElse(null);
    }

    @Override
    public Tenant saveTenant(Tenant tenant) {
        return tenantRepository.save(tenant);
    }

    @Override
    public void deleteTenant(Long id) {
        tenantRepository.deleteById(id);
    }
    
    @Override
    public Tenant updateTenant(Long id, Tenant updatedTenant) {
        Tenant existingTenant = tenantRepository.findById(id).orElse(null);
        if (existingTenant != null) {
            updatedTenant.setId(id);
            return tenantRepository.save(updatedTenant);
        }
        return null; // Or throw a custom exception indicating that the tenant with the given id was not found
    }
}
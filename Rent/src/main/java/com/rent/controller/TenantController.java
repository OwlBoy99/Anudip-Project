package com.rent.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rent.model.Tenant;
import com.rent.service.TenantService;

@RestController
@RequestMapping("/api/tenants")
public class TenantController {

    @Autowired
    private TenantService tenantService;

    @GetMapping
    public List<Tenant> getAllTenants() {
        return tenantService.getAllTenants();
    }

    @GetMapping("/{id}")
    public Tenant getTenantById(@PathVariable Long id) {
        return tenantService.getTenantById(id);
    }

    @PostMapping
    public Tenant saveTenant(@RequestBody Tenant tenant) {
        return tenantService.saveTenant(tenant);
    }

    @DeleteMapping("/{id}")
    public void deleteTenant(@PathVariable Long id) {
        tenantService.deleteTenant(id);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Tenant> updateTenant(@PathVariable Long id, @RequestBody Tenant updatedTenant) {
        Tenant tenant = tenantService.getTenantById(id);
        if (tenant != null) {
            updatedTenant.setId(id);
            Tenant updated = tenantService.saveTenant(updatedTenant);
            return ResponseEntity.ok(updated);
        } else {
            return ResponseEntity.notFound().build();
        }
}}

package com.rent.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody; // Make sure to import this
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rent.model.User;
import com.rent.service.LoginService;
@RestController
@RequestMapping("/api/login")
@CrossOrigin(origins = "*")
public class LoginController {
    @Autowired
    private LoginService loginService;

    @PostMapping
    public ResponseEntity<String> login(@RequestBody User user) {
        if (loginService.authenticate(user)) {
            // Return a JSON response with success message
            return ResponseEntity.ok().body("{\"message\": \"Login successful\"}");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("{\"message\": \"Authentication failed\"}");
        }
    }
}
